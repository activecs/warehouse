$(function() {
	initDataTable();
	initValidationRules();

	$("#phone").mask("?(999) 999-9999");

	$('#addContactB').click(function() {
		addContact();
	});
	$('#updateContactB').click(function() {
		updateContact();
	});
	$('#addCnt').click(function() {
		cleanForm();
		changeToUpdate(false);
	});

	oTable = $('#contacts').dataTable();
	$('#contacts').on('click', 'tr', function(e) {
		var oData = oTable.fnGetData(this);
		console.log(oData);
		if (e.target.getAttribute('delete-id')) {
			deleteContact(oData.id);
		}
		if (e.target.getAttribute('update-id')) {
			changeToUpdate(true);
			prepareUpdateContact(oData.id);
		}
	});

});

function convertFormToJSON(form) {
	var array = $(form).serializeArray();
	var json = {};
	var address = {};

	$.each(array, function() {
		if(this.name == 'country')
			address[this.name] = this.value || '';
		else if(this.name == 'city'){
			address[this.name] = this.value || '';
			json['address'] = address;
		} else
			json[this.name] = this.value || '';
	});

	return JSON.stringify(json);
}

function cleanForm() {
	$('#supplierForm')[0].reset();
	$(':input[type=hidden]').val('');
}

function addContact() {
	var addForm = $('#supplierForm');
	addForm.validate();
	if (addForm.valid()) {
		jQuery.ajax({
			type : 'POST',
			url : '/supplier',
			dataType : 'json',
			contentType: "application/json; charset=utf-8",
			processData: false,
			data : convertFormToJSON(addForm),
			success : function(data) {
				if (data.id) {
					reloadContent();
				}
				$('#addContactModal').modal('hide');
				cleanForm();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert(textStatus + '\n' + errorThrown);
			}
		});
	}
}

function prepareUpdateContact(id) {
	var supplier = getContact(id);
	if (supplier) {
		var form = document.supplierForm;
		form.id.value = supplier.id;
		form.code.value = supplier.code;
		form.name.value = supplier.name;
		form.surname.value = supplier.address.surname;
		form.country.value = supplier.address.country;
		form.city.value = supplier.city;

		$('#addContactModal').modal('show');
	}
}

function changeToUpdate(condition) {
	var addLabel =  $('#addContactModalLabel');
	var addBtn =  $('#addContactB');
	
	var updateLabel =  $('#updateContactModalLabel');
	var updateBtn =  $('#updateContactB');
	if (condition) {
		updateLabel.css({'display' : 'block'});
		updateBtn.css({'display' : 'inline-block'});
		addLabel.css({'display' : 'none'});
		addBtn.css({'display' : 'none'});
	} else {
		addLabel.css({'display' : 'block'});
		addBtn.css({'display' : 'inline-block'});
		updateLabel.css({'display' : 'none'});
		updateBtn.css({'display' : 'none'});
	}
}

function updateContact() {
	var addForm = $('#supplierForm');
	addForm.validate();
	if (addForm.valid()) {
		jQuery.ajax({
			type : 'PUT',
			url : '/supplier',
			dataType : 'json',
			contentType: "application/json",
			data : convertFormToJSON(addForm),
			success : function(data) {
				if (data.id) {
					reloadContent();
				}
				$('#addContactModal').modal('hide');
				cleanForm();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert(textStatus + '\n' + errorThrown);
			}
		});
	}
}

function deleteContact(id) {
	jQuery.ajax({
		type : 'DELETE',
		url : '/supplier/'+id,
		success : function() {
			reloadContent();
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert(textStatus + '\n' + errorThrown);
		}
	});
}


function getContact(id) {
	var contact;
	if (id > -1) {
		jQuery.ajax({
			type : 'GET',
			async: false,
			dataType : 'json',
			contentType: "application/json",
			url : '/supplier/'+id,
			success : function(data) {
				contact = data;
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert(textStatus + '\n' + errorThrown);
			}
		});
	}
	return contact;
}

function reloadContent() {
	var table = $('#contacts').DataTable();
	var info = table.page.info();
	var currentPage = info.page;
	table.ajax.reload();
	if (currentPage <= info.pages) {
		table.page(currentPage).draw(false);
	} else {
		table.page(info.pages-1).draw(false);
	}
	
}

function initValidationRules() {
	$('#supplierForm').validate({
		debug : true,
		rules : {
			id : {
				required : false
			},
			code : {
				required : true,
				minlength : 3
			},
			name : {
				required : true,
				minlength : 3
			},
			surname : {
				required : true,
				minlength : 3
			},
			country : {
				required : true,
				minlength : 3
			},
			city : {
				required : true,
				minlength : 3
			}
		}
	});
}

function initDataTable() {
	$('#contacts').dataTable({
		'ajax' : {
			'url' : '/supplier',
			'type' : 'GET',
			'dataSrc' : ''
		},
		"bStateSave": true,
		'aoColumns' : [
		               {
			'mData' : 'id',
			'sWidth' : '2%',
			'bSortable': false,
			'bSearchable' : false,
			'mRender' : function(id, type, full) {
				return '';
			}
		}, 
		{'mData' : 'code'},
		{'mData' : 'name'},
		{'mData' : 'surname'},
		{'mData' : 'address.country'},
		{'mData' : 'address.city'},
		{
			'mData' : 'delete',
			'sWidth' : '5%',
			'bSortable': false,
			'bSearchable' : false,
			'mRender' : function(text, type, full) {
				return '<button type="button" delete-id='+full.id+' class="btn btn-default btn-xs" aria-label="Left Align">'+
				'<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Remove</butto>';
			}
		}],
		'fnRowCallback' : function(nRow, aData, iDisplayIndex){
            	$("td:first", nRow).html('<button type="button" update-id='+aData.id+' class="btn btn-link btn-xs">'+ ++iDisplayIndex +'</button>');
           return nRow;
        },
	});
}