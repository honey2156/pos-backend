package com.example.pos.constants;

/**
 * @author mandeepsingh
 *
 */
public class ResourceConstants {
	// Customer constants
	public static final String CUSTOMERS_BASE = "customers";
	public static final String CUSTOMERS_SEED = "/seed";
	public static final String CUSTOMERS_SEARCH = "/{searchPattern}";

	// CashDrawer constants
	public static final String CASHDRAWER_BASE = "employees/{employeeId}/drawers";
	public static final String CASHDRAWER_ALL = "/all";
	public static final String CASHDRAWER_ORDERS = "cashdrawers/{cashDrawerId}/orders";

	// Employee constants
	public static final String EMPLOYEE_BASE = "/employees";
	public static final String EMPLOYEE_SEED = "/seed";
	public static final String EMPLOYEE_LOGIN = "/login";
	public static final String EMPLOYEE_ORDERS = "employees/{employeeId}/orders";

	// Product constants
	public static final String PRODUCT_BASE = "/products";
	public static final String PRODUCT_SEED = "/seed";
	public static final String PRODUCT_SEARCH = "/{searchPattern}";

	// Order constants
	public static final String PLACE_ORDER = "employees/{employeeId}/customers/{customerId}/orders";
	public static final String CONFIRM_ORDER = "employees/{employeeId}/customers/{customerId}/orders/{orderId}";
}
