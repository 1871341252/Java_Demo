from flask import Flask,render_template

app = Flask(__name__)

@app.route("/login.html")
def login():
    #return render_template("index.html")
    return render_template("login.html")

@app.route("/register.html")
def register():
    return render_template("register.html")

@app.route("/resetpwd.html")
def resetpwd():
    return render_template("resetpwd.html")

if __name__ == "__main__":
    app.run(host='192.168.0.112',port='9878',debug=True)
