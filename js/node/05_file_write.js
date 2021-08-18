//파일시스템 모듈 로드
const fs = require('fs');
var txt = "Hello World";
fs.writeFile("write_text.txt",txt,"utf-8",function(err){
    if(err)
        console.log(err);
    else
        console.log("파일이 정상적으로 저장되었습니다.");

});

fs.appendFile("append_text.txt",txt,"utf-8",function(err){
    if(err)
        console.log(err);
    else
        console.log("파일이 정상적으로 저장되었습니다.");

});

//비동기식
fs.writeFileSync("write_sync.txt","data","utf-8");
fs.appendFileSync("write_sync.txt","data","utf-8");