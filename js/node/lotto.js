const fs = require('fs');

//로또번호 5셋트를 파일 생성해서 저장
//lotto.txt에 저장
for(i=0;i<5;i++){
    let arr = [];
    while(arr.length < 6){
        let n = Math.floor(Math.random() * 45) + 1;
        if(arr.indexOf(n) != -1)
            continue;
        arr.push(n);
    }
    console.log(arr);
    fs.appendFile("lotto.txt",arr.join(",")+"\n","utf-8",function(err){
        if(err){
            console.log("에러 발생");
        }
    });
}

