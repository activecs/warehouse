package com.kharkiv.warehouse.util;

public final class QueryNamesConstants {

	private QueryNamesConstants() {
	}

	public static class ProductQueries {
		private ProductQueries() {
		}

		public static final String GET_ALL = "Product.getAll";
		public static final String GET_BY_ID = "Product.getById";
		public static final String DELETE_BY_ID = "Product.deleteById";
	}
	
	public static class SupplierQueries {
		private SupplierQueries() {
		}

		public static final String GET_ALL = "Supplier.getAll";
		public static final String GET_BY_ID = "Supplier.getById";
		public static final String GET_BY_NAME_AND_SURNAME = "Supplier.getByNameAndSurname";
		public static final String DELETE_BY_ID = "Supplier.deleteById";
	}
	
	public static class SupplyQueries {
		private SupplyQueries() {
		}

		public static final String GET_ALL = "Supply.getAll";
		public static final String GET_BY_ID = "Supply.getById";
		public static final String DELETE_BY_ID = "Supply.deleteById";
	}
	
}
