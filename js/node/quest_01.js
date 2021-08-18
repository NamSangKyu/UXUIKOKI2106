//숫자 10개 입력받아서 입력받은 숫자들의 총합을 출력
const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout
});

console.log("숫자 10개를 입력");
var total = 0;
var count = 0;
rl.on("line",function(data){
    total += Number(data);
    count++;
    if(count == 10){
        console.log(`total = ${total}`);
        rl.close();
    }
});
rl.on("close",function(){
    process.exit();
});