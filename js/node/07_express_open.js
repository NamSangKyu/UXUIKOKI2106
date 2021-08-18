const fs = require("fs");
//express 모듈 로드
const express = require('express');

//서버 객체 생성
const app = express();
//포트 번호
const port = 3000;

app.listen(port,()=>{
    console.log(`서버 오픈 완료, 포트번호 : ${port}`)
    fs.appendFileSync("log.txt",`서버 오픈 완료, ${new Date().toLocaleString()}, 포트번호 ${port}\n`);
});

//사용자로부터 요청을 받고 응답하는 부분
app.get('/',(request,response)=>{
    response.send("웹서버 접속 완료");
});

app.get('/login.do',(req,res)=>{
    res.send("로그인 처리 페이지");
    console.log(req.query);
});

//CORS 처리
app.all('/*',(req,res,next)=>{
    console.log(req);
    next();
});

//경로 /sendDate --> 사용자에게 현재 서버 시간을 전송
app.get("/sendDate",(req,res) =>{
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



