from flask import Flask, render_template, request, redirect, url_for

app = Flask(__name__)

products = [
    {"id": 1, "name": "Laptop", "price": 1200, "description": "Powerful laptop for work", "image": "laptop.jpg"},
    {"id": 2, "name": "Phone",  "price": 800,  "description": "Modern smartphone",        "image": "phone.jpg"},
]

@app.get("/")
@app.get("/products")
def products_view():
    return render_template("products.html", products=products)

@app.route("/add", methods=["GET", "POST"])
def add_product():
    if request.method == "POST":
        data = request.form.to_dict()
        data["id"] = (max(p["id"] for p in products) + 1) if products else 1
        products.append(data)
        return redirect(url_for("products_view"))
    return render_template("add_product.html")

@app.get("/product/<int:product_id>")
def product_detail(product_id):
    product = next((p for p in products if p["id"] == product_id), None)
    return render_template("product_detail.html", product=product)

if __name__ == "__main__":
    app.run(debug=True)
