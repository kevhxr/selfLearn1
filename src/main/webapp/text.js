var socket;
if(window.WebSocket){
    socket = new WebSocket("ws://localhost:8899/ws");
    socket.onmessage = function(event){
        var ta = document.getElementById("responseText");
        ta.value = ta.value+"\n"+event.data;
    }
    socket.onopen = function(event){
        var ta = document.getElementById("responseText");
        ta.value = "connection start";
    }
    socket.onclose= function(event){
        var ta = document.getElementById("responseText");
        ta.value = ta.value + "\n" +"connection close!";
    }
}else{
    alert("not support websocket")
}

function send(message){
  if(!window.WebSocket){
    return;
  }
  if(socket.readyState == WebSocket.OPEN){
        socket.send(message);
  }else{
    alert("conection not opened yet");
  }
}