<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
</head>
<body>
    <div align="center" style="background-color: #684D91; height: 100px; vertical-align: middle;">
        <h1 style="display: inline-block; color: white"><a href="/">Product</a></h1>
    </div>
    <nav class="navbar navbar-default">
       <ul class="nav navbar-nav navbar-left">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Change Entity <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="/product/page">Product</a></li>
            <li><a href="/supplier/page">Supplier</a></li>
            <li><a href="/supply/page">Supply</a></li>
          </ul>
        </li>
      </ul>
    </nav>
    <div align="center" style="margin-top: 10px">
        <button id="addCnt" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#addContactModal">Add Product</button>
    </div>
    <div style="padding: 1%">
        <table id="contacts" class="table table-striped table-bordered dataTable no-footer">
            <thead>
                <tr>
                    <th>Index</th>
                    <th>Product Name</th>
                    <th>SKU</th>
                    <th>Price</th>
                    <th>Stock amount</th>
                    <th>Description</th>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    
    <div class="modal fade" id="addContactModal" tabindex="-1" role="dialog" aria-labelledby="addContactModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="addContactModalLabel">Add Product</h4>
                <h4 class="modal-title" style="display: none;" id="updateContactModalLabel">Update Product</h4>
              </div>
              <div class="modal-body">
                <form role="form" name="productForm" id="productForm">
                    <input type="hidden" name="id" id="id"/>
                  <div class="form-group">
                    <label for="name">Product Name</label>
                    <input type="text" name="name" class="form-control" id="name" placeholder="Enter Product Name">
                  </div>
                  <div class="form-group">
                    <label for="sku">SKU</label>
                    <input type="text" name="SKU" class="form-control" id="sku" placeholder="Enter Product SKU">
                  </div>
                  <div class="form-group">
                    <label for="price">Price</label>
                    <input type="text" name="price" class="form-control" id="price" placeholder="Enter Product Price">
                  </div>
                  <div class="form-group">
                    <label for="description">Description</label>
                    <input type="text" name="description" class="form-control" id="description" placeholder="Enter Product Description">
                  </div>
                  <div class="form-group">
                    <label for="description">Stock Amount</label>
                    <input type="text" name="stockAmount" class="form-control" id="stockAmount" placeholder="Enter Product Stock">
                  </div>
                </form>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-primary" style="display: none;" id="updateContactB">Update</button>
                <button type="button" class="btn btn-primary" id="addContactB">Add</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>
            </div>
        </div>
    </div>
    
    
    <script type="text/javascript" src="<c:url value='/resources/js/jquery-1.10.2.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/dataTables.bootstrap.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.validate.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/product.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.maskedinput.js'/>"></script>
</body>
</html>
