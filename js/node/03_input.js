const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout
});
rl.on("line",function(data){
    console.log("입력 받은 데이터 : ",data.split(" "));
    rl.close();
});
rl.on("close",function(){
    process.exit();
});