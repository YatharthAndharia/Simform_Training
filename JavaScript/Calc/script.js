const screen=document.getElementById('screen');
//console.log(screen);
function isOperator(op)
{
    if(op=='/' || op=='*' || op=='+' || op=='-' || op=='**' || op=='%')
    {
        return(true);
    }
    else
    {
        return false;
    }
}
function addToClipBoard(ele)
{
    let ch=ele.getAttribute('value');
    // To avoid duplication of operators
    if(isOperator(ch))
    {
        if(isOperator(screen.value[screen.value.length-1]))
        {
        }
        else
        {
            screen.value+=ch;        
        }
    }
    // To avoid duplication of .
    else if(ch=='.')
    {
        var cnt_dot=0,cnt_op=0;
        for(let i=0;i<screen.value.length;i++)
        {
            if(screen.value[i]=='.')
                cnt_dot++;
            else if(isOperator(screen.value[i]))
                cnt_op++;
        }
        if(cnt_dot<=cnt_op)
            screen.value+=ch;
    }
    else
    {
        screen.value+=ch;
        if(ele.getAttribute('id')=="PI")
        {
            screen.value+=Math.PI;
        }
        else if(ele.getAttribute('id')=="E")
        {
            screen.value+=Math.E;
        }
    }
}

let deg=false;
function degree()
{
    if(!deg)
    {
        screen.value=parseFloat(screen.value) * 180/Math.PI;
        deg=true;
    }
}
function radian()
{
     if(deg)
     {
         screen.value=parseFloat(screen.value) * Math.PI/180;
         deg=false;
     }
}
class Trigo{
    sin()
    {
        //console.log(typeof(Math.sin(screen.value)));
        if(isNaN(Math.sin(screen.value)))
            screen.value=Math.sin(eval(screen.value));
        else
            screen.value=Math.sin(screen.value);
        if(screen.value==1.2246467991473532e-16 || screen.value==-1.2246467991473532e-16)
        {
            screen.value=0;
        }
    }
    cos()
    {
        if(isNaN(Math.cos(screen.value)))
            screen.value=Math.cos(eval(screen.value));
        else
            screen.value=Math.cos(screen.value);
        if(screen.value==1.2246467991473532e-16 || screen.value==-1.2246467991473532e-16 || screen.value==6.123233995736766e-17)
        {
            screen.value=0;
        }
    }
    tan()
    {
        if(isNaN(Math.tan(screen.value)))
            screen.value=Math.tan(eval(screen.value));
        else
            screen.value=Math.tan(screen.value);
        if(screen.value==1.2246467991473532e-16 || screen.value==-1.2246467991473532e-16)
        {
            screen.value=0;
        }
        else if(screen.value==16331239353195370)
            screen.value='infinity';
    }
    cot()
    {
        if(isNaN(Math.tan(screen.value)))
            screen.value=Math.tan(eval(screen.value));
        else
            screen.value=Math.tan(screen.value);
        if(screen.value==1.2246467991473532e-16 || screen.value==-1.2246467991473532e-16)
        {
            screen.value=0;
        }
        screen.value=1/screen.value;
    }
    sec()
    {
        if(isNaN(Math.cos(screen.value)))
            screen.value=Math.cos(eval(screen.value));
        else
            screen.value=Math.cos(screen.value);
        if(screen.value==1.2246467991473532e-16 || screen.value==-1.2246467991473532e-16)
        {
            screen.value=0;
        }
        screen.value=1/screen.value;
        if(screen.value==16331239353195370)
            screen.value='infinity';
    }
    cosec()
    {
        if(isNaN(Math.sin(screen.value)))
            screen.value=Math.sin(eval(screen.value));
        else
            screen.value=Math.sin(screen.value);
        if(screen.value==1.2246467991473532e-16 || screen.value==-1.2246467991473532e-16)
        {
            screen.value=0;
        }
        screen.value=1/screen.value;
    }
}
var tr=new Trigo();
class Functions
{
    random()
    {
        screen.value=Math.random();
    }
    ceiling()
    {
        if(isNaN(Math.ceil(screen.value)))
            screen.value=Math.ceil(eval(screen.value));
        else
            screen.value=Math.ceil(screen.value);
    }
    floor()
    {
        if(isNaN(Math.floor(screen.value)))
            screen.value=Math.floor(eval(screen.value));
        else
            screen.value=Math.floor(screen.value);
    }
}
var fn=new Functions();

var second_flag=true;
function second()
{
    if(second_flag)
    {
        document.getElementById('x2').innerHTML='x<sup>3</sup>';
        document.getElementById('tenpowx').innerHTML='2<sup>x</sup>';
        second_flag=false;
    }
    else
    {
        document.getElementById('x2').innerHTML='x<sup>2</sup>';
        document.getElementById('tenpowx').innerHTML='10<sup>x</sup>';
        second_flag=true;
    }
}
function AC()
{
    screen.value="";
}
function clr()
{
    screen.value=screen.value.slice(0,-1);
}
function square()
{
    if(document.getElementById('x2').innerHTML.includes('2'))
    {
        if(isNaN(screen.value*screen.value))
            screen.value=eval(screen.value)*eval(screen.value);
        else
            screen.value=screen.value*screen.value;
    }
    else
    {
        if(isNaN(screen.value*screen.value))
            screen.value=eval(screen.value)*eval(screen.value)*eval(screen.value);
        else
            screen.value=screen.value*screen.value*screen.value;
    }
}
function inverse()
{
    if(isNaN(1/screen.value))
            screen.value=1/eval(screen.value);
    else
        screen.value=1/screen.value;
}
function absolute()
{
    if(screen.value<0)
    {
        if(isNaN(Math.abs(screen.value)))
            screen.value=Math.abs(eval(screen.value));
        else
            screen.value=Math.abs(screen.value);
        
    }
}
function exponent()
{
    if(isNaN(Math.pow(Math.E,screen.value)))
        screen.value=Math.pow(Math.E,eval(screen.value));
    else
        screen.value=Math.pow(Math.E,screen.value);
}
function fact()
{
    var num = screen.value;
    if(isNaN(num))
        num=eval(screen.value);
    try{
        function factorial (num){
            if (num==0 || num==1){
            return 1;
            }
            return factorial(num-1)*num;
        }
        screen.value = factorial(num);
    }
    catch{
        screen.value = "Infinity";
    }
}
function squareRoot()
{
    if(isNaN(Math.sqrt(screen.value)))
        screen.value=Math.sqrt(eval(screen.value));
    else
        screen.value=Math.sqrt(screen.value);
}
function tenpowx()
{
    if(isNaN(Math.pow(10,screen.value)))
    {
        if(document.getElementById('tenpowx').innerHTML.includes('10'))
            screen.value=Math.pow(10,eval(screen.value));
        else
            screen.value=Math.pow(2,eval(screen.value));
    }
    else
    {
        if(document.getElementById('tenpowx').innerHTML.includes('10'))
            screen.value=Math.pow(10,screen.value);
        else
            screen.value=Math.pow(2,screen.value);
    }
    
}
function logx()
{
    if(isNaN(Math.log10(screen.value)))
        screen.value=Math.log10(eval(screen.value));
    else
        screen.value=Math.log10(screen.value);
}
function lnx()
{
    if(isNaN(Math.log(screen.value)))
        screen.value=Math.log(eval(screen.value));
    else
        screen.value=Math.log(screen.value);
}
function rev()
{
    if(screen.value>0)
    {
        screen.value=screen.value-2*screen.value;
    }
    else
    {
        screen.value=parseFloat(screen.value)-parseFloat(2*screen.value);
    }
}
class M
{
    memory=0;
    mplus()
    {
        this.memory+=parseFloat(screen.value);
        document.getElementById('btnmc').disabled=false;
        document.getElementById('btnmr').disabled=false;

    }
    mminus()
    {
        this.memory-=parseFloat(screen.value);
        document.getElementById('btnmc').disabled=false;
        document.getElementById('btnmr').disabled=false;
    }
    ms()
    {
        this.memory=screen.value;
        document.getElementById('btnmc').disabled=false;
        document.getElementById('btnmr').disabled=false;
    }
    mr()
    {
        screen.value+=this.memory;
    }
    mc()
    {
        this.memory="";
        screen.value=this.memory;
        document.getElementById('btnmc').disabled=true;
        document.getElementById('btnmr').disabled=true;
    }
}
var mem=new M();

function equalsTo()
{
    var str=screen.value;
    try {
        screen.value=eval(str);    
    } catch (error) {
        screen.value="Illegal Expression";
    }
    
}