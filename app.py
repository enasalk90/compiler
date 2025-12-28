from flask import Flask, render_template, request, redirect, url_for

app = Flask(__name__)

# ================== بيانات المنتجات ==================
products = [
    {"id": 1, "name": "Laptop", "price": 1200, "description": "High performance laptop"},
    {"id": 2, "name": "Phone", "price": 800, "description": "Latest smartphone"},
    {"id": 3, "name": "Headphones", "price": 150, "description": "Noise cancelling headphones"},
]

# ================== الصفحة الرئيسية ==================
@app.route("/")
def home():
    return render_template(
        "products.html",
        title="المنتجات",
        products=products
    )

# ================== تفاصيل المنتج ==================
@app.route("/product/<int:product_id>")
def product_details(product_id):
    product = next((p for p in products if p["id"] == product_id), None)
    if not product:
        return "المنتج غير موجود", 404

    return render_template(
        "product_details.html",
        title="تفاصيل المنتج",
        product=product
    )

# ================== إضافة منتج ==================
@app.route("/add-product", methods=["GET", "POST"])
def add_product():
    if request.method == "POST":
        new_id = max(p["id"] for p in products) + 1 if products else 1

        products.append({
            "id": new_id,
            "name": request.form["name"],
            "price": request.form["price"],
            "description": request.form["description"]
        })

        return redirect(url_for("home"))

    return render_template(
        "add_product.html",
        title="إضافة منتج"
    )

if __name__ == "__main__":
    app.run(debug=True)
