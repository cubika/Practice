# 持续更新中。。。
+ 请看以下代码，按照下面的要求回答:
    ```
    if(window.addEventListener){
    	var fn = function (type,fn,useCapture){
        	el.addEventListener(type,fn,useCapture);
      	}
    }
    else if(window.attachEvent){
    	fn = function (type,fn){
        	el.attachEvent('on'+type,);
        }
    }
    ```
  1. 以上代码的作用
  2. 以上代码的优点
  3. 以上代码中的问题，如果你有更好的，请把它编写出来
  
+ 请计算下面变量的值:
    ```
    var a= (Math.PI++);
    var b = (Math.PI++);
    alert(a);
    alert(b);
    ```
+ 注释的代码是否可以实现？如不能实现，请修改;
    ```
    function test(){
    	this.name = 'taobao';
    	this.waitMes = function (){
    		//隔5秒钟执行this.name
    	}
    }
    ```
*Note:* 以上来自：[W3Cfun](http://www.w3cfuns.com/thread-1947-1-1.html)

+ 解释下事件代理。
+ 解释下 JavaScript 中 this 是如何工作的。
+ 解释下原型继承的原理。
+ 你是如何测试JavaScript代码的？
+ AMD vs. CommonJS？
+ 解释下为什么接下来这段代码不是 IIFE(立即调用的函数表达式)：`function foo(){ }();.`要做哪些改动使它变成 IIFE?
+ 描述以下变量的区别：null，undefined 或 undeclared？该如何检测它们？
+ 什么是闭包，如何使用它，为什么要使用它？闭包的好处和坏处？
+ 请举出一个匿名函数的典型用例？
+ 请指出 JavaScript 宿主对象和原生对象的区别？
+ .call 和 .apply 的区别是什么？
+ 请解释 `Function.prototype.bind` 的作用？
+ 你能解释一下 JavaScript 中的继承是如何工作的吗？
+ 请指出浏览器特性检测，特性推断和浏览器 UA 字符串嗅探的区别？
+ 请尽可能详尽的解释 AJAX 的工作原理。
+ 请解释 JSONP 的工作原理，以及它为什么不是真正的 AJAX。
+ 你使用过 JavaScript 模板系统吗？
+ 请解释变量声明提升。
+ 请描述下事件冒泡机制。
+ "attribute" 和 "property" 的区别是什么？
+ 扩展 JavaScript 内置对象的优缺点
+ 请指出 document load 和 document ready 两个事件的区别。
+ `== `和 `===` 有什么不同？
+ 你如何从浏览器的 URL 中获取查询字符串参数。
+ 请解释一下 JavaScript 的同源策略。
+ 请描述一下 JavaScript 的继承模式。
+ 如何实现下列代码：
	`[1,2,3,4,5].duplicator(); // [1,2,3,4,5,1,2,3,4,5]`
+ 描述一种 JavaScript 中实现 memoization(避免重复运算)的策略。
+ 什么是 "use strict"; ? 使用它的好处和坏处分别是什么？
+ 哪那些操作会造成内存泄漏？
+ 实现输出document对象中所有成员的名称和类型
+ 如何获得一个DOM元素的绝对位置？（获得元素位置，不依赖框架）
+ 如何利用JS生成一个table？
+ 实现预加载一张图片，加载完成后显示在网页中并设定其高度为50px，宽度为50px；
+ 假设有一个4行td的table，将table里面td顺序颠倒；
+ 模拟一个HashTable类，包含有add、remove、contains、length方法；
+ JS如何实现面向对象和继承机制？
+ JS模块的封装方法，比如怎样实现私有变量，不能直接赋值，只能通过公有方法；
+ 对this指针的理解，可以列举几种使用情况？