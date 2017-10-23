var Local = function () {
  // 游戏对象
  var game;
  // 时间间隔
  var INTERVAL = 800;

  // 定时器
  var timer = null;

  // 时间计数器
  var time = 0;
  var timeCount = 0;

  var noChanged = false;

  var noChangedBlock = 0;

  // 绑定键盘事件
  var bindKeyEvent = function (doms) {
   /* document.onkeydown = function (e) {
      if (e.keyCode == 38) { // up
        game.rotate();
      } else if (e.keyCode == 39) { // right
        game.right();
      } else if (e.keyCode == 40) { // down
        game.down();
      } else if (e.keyCode == 37) { // left
        game.left();
      } else if (e.keyCode == 32) { // space
        game.fall();
      }
    }*/
      var rotate = document.getElementById("btnImg_rotate");
      var left = document.getElementById("btnImg_left");
      var right = document.getElementById("btnImg_right");
      var down = document.getElementById("btnImg_down");

      var stage2 = document.getElementById("stage2");

      stage2.onclick = function () {
          console.log("gggggggggg----"+game.stage);
          if(game.stage>0){
              game.stage-=1;
              doms.stage2_num.innerHTML = game.stage;

         //     game.addBotLine(generateBotLine(1)); /*道具向别人使用  底部增加行*/
          }
 //         game.cleanBoLine();  /*  道具  底部减去行*/

         /* var timeout = false; //启动及关闭按钮
          function time()
          {
              if(timeout) return;
              Method();
              setTimeout(time,100); //time是指本身,延时递归调用自己,100为间隔调用时间,单位毫秒
          }*/
    //     expedite();

  //        retard();

   //       game.addBotLine(generateBotLine(1))

  //        game.cleanBoLine(1);  /*  道具  底部减去行*/

          /*解除  buff*/


          noChanged = true;    /*定身*/


      }
      
      function expedite() {                /*加速*/
          clearInterval(timer);//关闭
          INTERVAL = 100;
          timer=setInterval(move,INTERVAL) ;//重新启动

          setTimeout(function () {
              clearInterval(timer);
              INTERVAL = 800;
              timer = setInterval(move,INTERVAL);
          },4000); //time是指本身,延时递归调用自己,100为间隔调用时间,单位毫秒
      }
      
      function retard() {                /*减速*/
          clearInterval(timer);
          INTERVAL = 1500;
          timer = setInterval(move,INTERVAL);

          setTimeout(function () {
              clearInterval(timer);
              INTERVAL = 800;
              timer = setInterval(move,INTERVAL);
          },4000)
          
      }

      rotate.addEventListener('touchstart', function () {
          console.log("jjjjjjjjjj");
          this.style.width = "89%";
      }, false);

      rotate.addEventListener('touchend', function () {
          console.log("jjjjjjjjjj44444")
          this.style.width = "100%";

          if(noChanged){
              return;
          }
          game.rotate();
      }, false);

      left.addEventListener('touchstart', function () {
          this.style.width = "89%"
      },false);
      left.addEventListener('touchend', function () {
          this.style.width = "100%"
          game.left();
      },false);

      right.addEventListener('touchstart', function(){
        this.style.width = "89%"
      },false)
      right.addEventListener('touchend', function () {
          this.style.width = "100%"
          game.right();
      },false);

      down.addEventListener('touchstart',function(){
        this.style.width = "89%"
      },false);
      down.addEventListener('touchend', function () {
          this.style.width = "100%"
          game.fall();
      },false);


     /* rotate.onclick = function(){
         game.rotate();
      }*/
      /*left.onclick = function () {
        game.left();
      }
      right.onclick = function(){
        game.right();
      }
      down.onclick = function () {
        game.fall();
      }*/
  }

  // 移动
  var move = function () {
    timeFunc();
    if (!game.down()) {
      game.fixed();

      if(noChanged){
          if(noChangedBlock ==1 ){
              noChanged = false;
          }
          noChangedBlock++;
      }

      var line = game.checkClear();
      if (line) {
        game.addScore(line);  /*随机获取道具*/
      }
      var gameOver = game.checkGameOver();
      if (gameOver) {
        game.onGameOver(false);
        stop();
      } else {
        game.performNext(generateType(), generateDir());
      }
    }
  }
  // 随机生成干扰行
  var generateBotLine = function (lineNum) {
    var lines = [];
    for (var i = 0; i < lineNum; i++) {
      var line = [];
      for (var j = 0; j < 10; j++) {
        line.push(Math.ceil(Math.random() * 2) - 1); // 生成 0 1 随机数
      }
      lines.push(line);
    }
    return lines;
  }
  // 计时函数
  var timeFunc = function () {
    timeCount += 1;
    if (timeCount == 5) {
      timeCount = 0;
      time += 1;
      game.setTime(time);
      if (time % 30 == 0) { // 60秒生成一行
        game.addBotLine(generateBotLine(1));
      }
    }
  }
  // 随机生成一个方块种类
  var generateType = function () {
    return Math.ceil(Math.random() * 7) - 1;
  }
  // 随机生成一个旋转次数
  var generateDir = function () {
    return Math.ceil(Math.random() * 4) - 1;
  }
  // 结束
  var stop = function () {
    if (timer) {
      clearInterval(timer);
      timer = null;
    }
    document.onkeydown = null;
  }
  // 开始
  var start = function () {
    var doms = {
      gameDiv: document.getElementById('local_game'),
      nextDiv: document.getElementById('local_next'),
      timeDiv: document.getElementById('local_time'),
      scoreDiv: document.getElementById('local_score'),
      resultDiv: document.getElementById('local_gameover'),
      stage2_num: document.getElementById('stage2_num'),
    }
    console.log("gameDiv===="+doms.gameDiv.offsetWidth)

    game = new Game();
    game.init(doms, generateType(), generateDir());
    bindKeyEvent(doms);
    game.performNext(generateType(), generateDir());
    timer = setInterval(move, INTERVAL);
  }

  this.start = start;
  //this.timer = timer

}