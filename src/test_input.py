from flask import Flask, render_template_string, request, redirect, url_for

app = Flask(__name__)

# ================== بيانات المنتجات ==================
products = [
    {"id": 1, "name": "Laptop", "price": 1200, "description": "High performance laptop"},
    {"id": 2, "name": "Phone", "price": 800, "description": "Latest smartphone"},
    {"id": 3, "name": "Headphones", "price": 150, "description": "Noise cancelling headphones"},
]

# ================== القالب الأساسي ==================
base_head = """
<!DOCTYPE html>
<html lang="ar">
<head>
    <meta charset="UTF-8">
    <title>{{ title }}</title>
    <style>
        body { font-family: Arial; background:#f4f4f4; margin:0; direction:rtl; }
        header { background:#222; color:#fff; padding:15px; text-align:center; }
        .container { max-width:900px; margin:20px auto; padding:20px; }
        .card { background:#fff; padding:15px; margin-bottom:15px; border-radius:6px; }
        a { color:#007bff; text-decoration:none; }
        input, textarea { width:100%; padding:8px; margin-bottom:10px; }
        button {
            padding:10px 14px;
            background:#007bff;
            color:#fff;
            border:none;
            cursor:pointer;
            border-radius:4px;
        }
        .add-btn {
            position: fixed;
            bottom: 20px;
            left: 20px;
            background: #28a745;
        }
    </style>
</head>
<body>
<header>
    <h1>Simple Store</h1>
    <a href="{{ url_for('home') }}" style="color:white;">المنتجات</a>
</header>
<div class="container">
"""

base_tail = """
</div>
</body>
</html>
"""

# ================== الصفحة الرئيسية ==================
@app.route("/")
def home():
    content = """
    <h2>قائمة المنتجات</h2>

    {% for product in products %}
        <div class="card">
            <h3>{{ product.name }}</h3>
            <p>السعر: ${{ product.price }}</p>
            <a href="{{ url_for('product_details', product_id=product.id) }}">
                عرض التفاصيل
            </a>
        </div>
    {% endfor %}

    <a href="{{ url_for('add_product') }}">
        <button class="add-btn">➕ إضافة منتج</button>
    </a>
    """
    return render_template_string(
        base_head + content + base_tail,
        title="المنتجات",
        products=products
    )

# ================== تفاصيل المنتج ==================
@app.route("/product/<int:product_id>")
def product_details(product_id):
    product = next((p for p in products if p["id"] == product_id), None)
    if not product:
        return "المنتج غير موجود", 404

    content = """
    <div class="card">
        <h2>{{ product.name }}</h2>
        <p>{{ product.description }}</p>
        <p><strong>السعر:</strong> ${{ product.price }}</p>
        <a href="{{ url_for('home') }}">العودة للمنتجات</a>
    </div>
    """
    return render_template_string(
        base_head + content + base_tail,
        title="تفاصيل المنتج",
        product=product
    )

# ================== إضافة منتج جديد ==================
@app.route("/add-product", methods=["GET", "POST"])
def add_product():
    if request.method == "POST":
        name = request.form.get("name")
        price = request.form.get("price")
        description = request.form.get("description")

        new_id = max(p["id"] for p in products) + 1 if products else 1

        products.append({
            "id": new_id,
            "name": name,
            "price": price,
            "description": description
        })

        return redirect(url_for("home"))

    content = """
    <h2>إضافة منتج جديد</h2>
    <div class="card">
        <form method="POST">
            <input type="text" name="name" placeholder="اسم المنتج" required>
            <input type="number" name="price" placeholder="السعر" required>
            <textarea name="description" placeholder="وصف المنتج" required></textarea>
            <button type="submit">حفظ المنتج</button>
        </form>
    </div>
    """
    return render_template_string(
        base_head + content + base_tail,
        title="إضافة منتج"
    )


# ================== إضافة طلب ==================
@app.route("/order/<int:product_id>", methods=["GET", "POST"])
def order(product_id):
    product = next((p for p in products if p["id"] == product_id), None)
    if not product:
        return "المنتج غير موجود", 404

    if request.method == "POST":
        name = request.form.get("name")
        address = request.form.get("address")

        content = """
        <div class="card">
            <h2>تم إرسال الطلب</h2>
            <p>العميل: {{ name }}</p>
            <p>المنتج: {{ product.name }}</p>
            <p>العنوان: {{ address }}</p>
            <a href="{{ url_for('home') }}">العودة للمنتجات</a>
        </div>
        """
        return render_template_string(
            base_head + content + base_tail,
            title="تم الطلب",
            name=name,
            address=address,
            product=product
        )

    content = """
    <h2>إضافة طلب للمنتج: {{ product.name }}</h2>
    <div class="card">
        <form method="POST">
            <input type="text" name="name" placeholder="اسم العميل" required>
            <textarea name="address" placeholder="العنوان" required></textarea>
            <button type="submit">إرسال الطلب</button>
        </form>
    </div>
    """
    return render_template_string(
        base_head + content + base_tail,
        title="إضافة طلب",
        product=product
    )

if __name__ == "__main__":
    app.run(debug=True)
