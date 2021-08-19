const express = require('express');

const app = express();
const port = 3000;

app.listen(port,()=>{
    console.log(`서버 오픈 완료, 포트번호 : ${port}`);
});
//CORS 오류 처리
app.all("/*",function(req,res,next){
    res.header("Access-Control-Allow-Origin","*");
    res.header("Access-Control-Allow-Headers","X-Requested-With");
    next();
});

app.get("/sendDate", (req, res) => {
    var now = new Date();
    var data = {};
    data['year'] = now.getFullYear();
    data['month'] = now.getMonth();
    data['day'] = now.getDate();
    data['hour'] = now.getHours();
    data['minute'] = now.getMinutes();
    data['second'] = now.getSeconds();
    data['date'] = now.toLocaleString();
    res.send(data);
});