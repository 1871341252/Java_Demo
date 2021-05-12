from flask import Flask,render_template,request,jsonify
from utils.tools import *

db=Db("192.168.31.85",3306,"root","123456","user")

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

@app.route("/index.html")
def index():
    return render_template("index.html")

@app.route("/login_tools",methods=['POST'])
def login_tools():
    username=request.form['username']
    password=request.form['password']
    # data={
    #     '用户名':username,
    #     '密码':password
    # }
    # return jsonify(data)
    list1=[]
    list2=[]
    temp=db.query("select username from auth_user",())
    for i in temp:
        list1.append(i[0])
    if username in list1:
        temp1=db.query("select password from auth_user where username=(%s)",(username))
        pwd=temp1[0][0]
        if pwd==password :
            return jsonify({'msg':'登录成功','status':'success','code':1000})
            # res1={'msg':'用户已存在','status':'fial'}
            # return res1
        else:
            return jsonify({'msg':'密码错误','status':'fial','code':1001})
    else:
        return jsonify({'msg':'用户名不存在','status':'fial','code':1002})
        # db.commit("INSERT INTO auth_user (username, PASSWORD) VALUES (%s,%s)",(username,password))
        # res2={'msg':'注册成功','status':'success'}
        # return res2

if __name__ == "__main__":
    app.run(host='192.168.31.85',port='9878',debug=True)
