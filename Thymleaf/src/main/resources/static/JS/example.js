console.log("Hello World")

alert("Hi This is a JS File")

name = prompt("Enter the Name")
alert("Hello "+name)
document.addEventListener("click", ()=>{
    alert("Hello"+name)
    document.getElementById("#name").innerText=name;
});
