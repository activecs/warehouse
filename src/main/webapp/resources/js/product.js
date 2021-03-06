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

function cleanForm() {
	$('#productForm')[0].reset();
	$(':input[type=hidden]').val('');
}

function addContact() {
	var addForm = $('#productForm');
	addForm.validate();
	if (addForm.valid()) {
		jQuery.ajax({
			type : 'POST',
			url : '/product',
			dataType : 'json',
			data : addForm.serialize(),
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
	var product = getContact(id);
	if (product) {
		
		var form = document.productForm;
		form.id.value = product.id;
		form.name.value = product.name;
		form.sku.value = product.sku;
		form.price.value = product.price;
		form.description.value = product.description;
		form.stockAmount.value = product.stockAmount;

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
	var addForm = $('#productForm');
	addForm.validate();
	if (addForm.valid()) {
		jQuery.ajax({
			type : 'PUT',
			url : '/product',
			dataType : 'json',
			data : addForm.serialize(),
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
		url : '/product/'+id,
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
			url : '/product/'+id,
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
	$('#productForm').validate({
		debug : true,
		rules : {
			id : {
				required : false
			},
			name : {
				required : true,
				minlength : 3
			},
			sku : {
				required : true,
				minlength : 3
			},
			price : {
				required : true,
				digits: true
			},
			stockAmount : {
				required : true,
				digits: true
			}
		}
	});
}

function initDataTable() {
	$('#contacts').dataTable({
		'ajax' : {
			'url' : '/product',
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
		{'mData' : 'name'},
		{'mData' : 'sku'},
		{'mData' : 'price'},
		{'mData' : 'stockAmount'},
		{'mData' : 'description'},
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