package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order o) {
        this.order = o;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();
		final String header="======Printing Orders======\n";
		output.append(header);
		printOrder(output);
		return output.toString();
	}

	private void printOrder(StringBuilder output) {
		output.append(order.getCustomerName());
		output.append(order.getCustomerAddress());

		double totSalesTx = 0d;
		double tot = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.getDescription()).append('\t');
			output.append(lineItem.getPrice()).append('\t');
			output.append(lineItem.getQuantity()).append('\t');
			output.append(lineItem.totalAmount()).append('\n');

			final double taxRate=.10d;
            double salesTax = lineItem.totalAmount() * taxRate;
            totSalesTx += salesTax;

            tot += lineItem.totalAmount() + salesTax;
		}

		final String salesTax="Sales Tax";
		output.append(salesTax).append('\t').append(totSalesTx);
		final String totalAmount="Total Amount";
		output.append(totalAmount).append('\t').append(tot);
	}
}
