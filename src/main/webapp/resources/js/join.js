const id = document.getElementById("id");
const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const name = document.getElementById("name");
const email = document.getElementById("email");
const birth = document.getElementById("birth");
const frm = document.getElementById("frm");
const btn = document.getElementById("btn");

console.log("member");


// ---ID Check----
// 빈칸x , 최대 10글자

id.addEventListener("blur", function(){
    console.log("id");
    console.log(id.id);
    const idResult= document.getElementById(id.id+"Result");
    
    if(id.value=="" || id.vaule.length >10) {
        console.log("xxxx");
        idResult.innerHTML="ID는 비어있음 안되고 10글자 미만이여야 합니다."
        idResult.className="f";
        // alert('ID를 입력 해 주세요')
        // id.focus()
        
    }else{
        console.log("ok");
        idResult.innerHTML="가능한 ID입니다";
        idResult.className="s";
    }

})

//---------------------------------------

//-----PW CHECK
pw.addEventListener("blur", function(){
    if(pw.length>5 && pw.length<12){
        const pwResult= document.getElementById(pw.id+"Result");
        pwResult.innerHTML="올바른 비밀번호 입니다";
        pwResult.className="s";
    }else{
     
        pwResult.innerHTML="비밀번호는 6글자 이상 12글자 미만이여야 합니다.";
        pwResult.className="f";
    }

})







// id 입력필수
// - 입력이 끝나고 난 후(다른곳으로 이동할떄) 검증
// -검증은 id입력칸 밑에 생성
// id 글자수 10 넘어가면 에러

// pw : 빈칸x 6글자 이상 12글자 미만
// -입력이 끝나고 난 후 검증
// pw2 : pw와 같은지 판별
// -글자를 입력할때마다 비교검증

// 이름 필수 빈칸x
// -입력이 끝나고 난 후 검증
// 이메일 빈칸x
// -입력이 끝나고 난 후 검증
// birth 빈칸x
// -회원가입버튼 클릭했을때 검증
