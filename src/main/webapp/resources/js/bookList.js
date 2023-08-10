const list = document.getElementById("list");


list.addEventListener("click", function(){
    
    let xhttp = new XMLHttpRequest();
    
    console.log("list");

    
    //open("method", "url")
    xhttp.open("GET", "./list?page=1");

    //send
    xhttp.send()

    xhttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200){
            console.log(this.responseText);
        }
    }




})