//파일시스템 모듈 로드
const fs = require('fs');

//동기식
const text = fs.readFileSync('temp_text.txt','utf-8');
console.log(`파일 내용 ${text}`);
console.log("--------------------------");
//비동기식
fs.readFile("temp_text.txt",'utf-8',function(err,txt){
    console.log(`파일 내용 ${txt}`);
});
console.log("-----프로세스 종료-----");