var num = 100;
if(num < 200){
    var n = -num;
}
console.log(num,n);

if(num < 200){
    let t = -100;
    console.log(`let = ${t}`);
}

const pi = 3.1415;
//pi = 1.2344323;
console.log(`pi = ${pi}`);

//오늘 날짜 시간 출력
const today = new Date();
today.setDate(20);
console.log(today.toLocaleString());