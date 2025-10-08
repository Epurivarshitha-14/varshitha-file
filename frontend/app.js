document.getElementById('expenseForm').addEventListener('submit', function(e) {
    e.preventDefault();
    // Here you’d send data to backend (ExpenseServlet) using AJAX/fetch
    // For demo, just show in frontend
    const form = e.target;
    const category = form.category.value;
    const amount = form.amount.value;
    const expensesDiv = document.getElementById('expenses');
    expensesDiv.innerHTML += `<div>${category}: $${amount}</div>`;
    // Update chart (sample)
    // ... You can use Chart.js to visualize expenses
});
