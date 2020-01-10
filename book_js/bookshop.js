const http = require('http');
const express= require('express');
const bodyParser = require('body-parser');

const hostname = '127.0.0.1';
const port = 3000;

var books=[];
var seq = 1;
        
books.push({
  bookid:seq++,
  bookname:"자바",
  publisher:"한빛미디어",
  price:10000
});

books.push({
  bookid:seq++,
  bookname:"HTML",
  publisher:"한빛미디어",
  price:5000
  });

books.push({
  bookid:seq++,
  bookname:"자바스크립트",
  publisher:"한빛미디어",
  price:77777
  });


var app = express();
app.use(express.static("."));
app.use(bodyParser.json());

app.get("/", (req,res)=>{
res.redirect("bookshop.html");
});

app.get("/books", (req,res)=>{
  if(req.query.bookid){
    var filtered = books.filter(value => value.bookid == req.query.bookid);

    
    res.send(filtered);
  }else
  res.send(books);
});

app.post("/books", (req,res)=>{
  req.body.bookid =seq++;
  books.push(req.body); 
  res.end();
});

app.put("/books", (req,res)=>{
  books.forEach(value => { 
    if(value.bookid == req.body.bookid){
        value.bookname = req.body.bookname;
        value.publisher = req.body.publisher;
        value.price = parseInt(req.body.price);
    }
});
  res.end();
});

app.delete("/books", (req,res)=>{
  books = books.filter(value => value.bookid != req.query.bookid);  //람다형
  res.end();
});

http.createServer(app).listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});