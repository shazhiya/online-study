let mysql = require('mysql')



let connection = mysql.createConnection({
    host: '101.200.47.9',
    user: 'root',
    password: 'root',
    port: 3306,
    database: 'online_study',
})

connection.connect()
userIds = []
roleIds = []
connection.query('select user_id from user where user_id != 1',(err,res)=>{
    res.forEach(row=>{
        userIds.push(row.user_id)
    })

    userIds.filter(uid=>Math.random()>0.7).forEach(uid=>{
        connection.query('update user set user_enable = false where user_id = ?',[uid],(err,res)=>{
            console.log(res)
        })
    })

    connection.end()

    /* user_role
    connection.query('select role_id from role', (err,res)=>{
        res.forEach(row=>{
            roleIds.push(row.role_id)
        })

        roleIds.forEach(rid=>{
            userIds.filter(id=>Math.random()>0.4).forEach(uid=>{
                connection.query('insert into user_role value(?,?)',[uid,rid])
            })
        })

        connection.end()
    })*/
})

/*
let insert = 'insert into user(user_name,password,user_email,user_intro,user_headico) value(?,"123456","2691032513@qq.com","I am hollow knight!",?)'
var path = require("path");
var fs = require("fs");
var dirs = [];
var pathName = "E:/MyProject/files/headIco";
fs.readdir(pathName, function(err, files){
    connection.connect()

    files.forEach((value,index)=>{
        connection.query(insert,['shazhi_'+index,'headIco/'+value],(err,result)=>{
            if(err){
                console.log('INSERT ERROR: '+ err)
            }
            console.log('INSERT SUCCESS: ' + result)
        })
    })
    connection.end()    
});*/






