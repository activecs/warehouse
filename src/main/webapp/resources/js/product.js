$(document).ready(function() {
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
	$('#contactForm')[0].reset();
	$(':input[type=hidden]').val('');
}

function addContact() {
	var addForm = $('#contactForm');
	addForm.validate();
	if (addForm.valid()) {
		jQuery.ajax({
			type : 'POST',
			url : '/contact',
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
	var contact = getContact(id);
	if (contact) {
		
		var form = document.contactForm;
		form.id.value = contact.id;
		form.firstName.value = contact.firstName;
		form.lastName.value = contact.lastName;
		form.phone.value = contact.phone;
		form.adress.value = contact.adress;

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
	var addForm = $('#contactForm');
	addForm.validate();
	if (addForm.valid()) {
		jQuery.ajax({
			type : 'PUT',
			url : '/contact',
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
		url : '/contact/'+id,
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
			url : '/contact/'+id,
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
	$('#contactForm').validate({
		debug : true,
		rules : {
			id : {
				required : false
			},
			firstName : {
				required : true,
				minlength : 3
			},
			lastName : {
				required : true,
				minlength : 3
			},
			phone : {
				required : true,
				minlength : 14,
				maxlength : 14
			},
			adress : {
				required : true,
			}
		}
	});
}

function initDataTable() {
	$('#contacts').dataTable({
		'ajax' : {
			'url' : '/contact',
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
		{
			'mData' : 'firstName'
		},{
			'mData' : 'lastName'
		}, {
			'mData' : 'phone'
		},{
			'mData' : 'adress'
		}, {
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