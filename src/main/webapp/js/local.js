var Local = function () {
  // 游戏对象
  var game;

  var socket;
  // 时间间隔
  var INTERVAL = 800;

  // 定时器
  var timer = null;
  var sec_1 = null;

  // 时间计数器
  var time = 0;
  var timeCount = 0;

  var noChanged = false; /*定身开关*/
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
      var stage1 = document.getElementById("stage1");
      var stage2 = document.getElementById("stage2");

      stage1.addEventListener('touchstart', function () {
          this.style.width = "89%";
          console.log("(game.na======"+game.na)
          if(game.d_a){
            alert("点击了第一个道具赋值之前"+game.na+propsName);
            propsName=game.na;
            alert("点击了第一个道具赋值"+propsName)
              // if(game.na == 4){
              //     noChanged  = true;     /*定身*/

              // }else if(game.na == 5){
              //     expedite()          /*加速*/

              // }else if(game.na == 6){         /*减速*/
              //     retard();

              // }else if(game.na == 7){       /*重生图片    解除buff*/

              // }else if(game.na == 8){   /*减去2行*/
              //     game.cleanBoLine(2)

              // }else if(game.na == 9){   /*减去1行*/
              //     game.cleanBoLine(1)

              // }else if(game.na == 10){      /*增加2行*/
              //     game.addBotLine(generateBotLine(2))

              // }else if(game.na == 11){           /*增加1行*/
              //     game.addBotLine(generateBotLine(1))

              // }

              game.d_a = false;
           //   console.log("(game.d_a里======"+(game.d_a));
              stage1.src = "../img/a/stage2.png"

          }

      },false);
      stage1.addEventListener('touchend', function () {
     //     console.log("jjjjjjjjjj44444")
          this.style.width = "100%";


          /*  if(noChanged){
           return;
           }*/
          //        game.rotate();
      }, false);
      stage2.addEventListener('touchstart', function () {
          this.style.width = "89%";
     //     console.log("game.nb=================="+game.nb)
       //   game.addBotLine(generateBotLine(2))
          if(game.d_b){
            alert("点击了第二个道具赋值之前"+game.nb+propsName);
            propsName=game.nb;
             alert("点击了第二个道具赋值"+propsName)
              // if(game.nb == 4){
              //     noChanged = true;

              // }else if(game.nb == 5){
              //     expedite();

              // }else if(game.nb == 6){
              //     retard();

              // }else if(game.nb == 7){

              // }else if(game.nb == 8){
              //     game.cleanBoLine(2)

              // }else if(game.nb == 9){
              //     game.cleanBoLine(1)

              // }else if(game.nb == 10){
              //     game.addBotLine(generateBotLine(2))

              // }else if(game.nb == 11){
              //     game.addBotLine(generateBotLine(1))

              // }
              game.d_b = false;
              stage2.src = "../img/a/stage1.png"
          }

      },false);
      stage2.addEventListener('touchend', function () {
          this.style.width = "100%";

          /*  if(noChanged){
           return;
           }*/
  //        game.rotate();
      }, false);


      rotate.addEventListener('touchstart', function () {
          console.log("jjjjjjjjjj");
          this.style.width = "89%";

          if(noChanged){
              return;
          }
          game.rotate();
      }, false);

      rotate.addEventListener('touchend', function () {
          console.log("jjjjjjjjjj44444")
          this.style.width = "100%";

        /*  if(noChanged){
              return;
          }*/

      }, false);
   
      left.addEventListener('touchstart', function () {
          this.style.width = "89%"
          game.left();
      },false);
      left.addEventListener('touchend', function () {
          this.style.width = "100%"

      },false);

      right.addEventListener('touchstart', function(){
          this.style.width = "89%"
          game.right();
      },false)
      right.addEventListener('touchend', function () {
          this.style.width = "100%"

      },false);

      down.addEventListener('touchstart',function(){
          this.style.width = "89%"
          game.fall();
       /*   $('#local_gameScene').removeClass("gameSceneCss");//添加样式
          $('#local_gameScene').toggleClass('gameSceneCss');*/
      },false);
      down.addEventListener('touchend', function () {
          this.style.width = "100%"
/*
          $('#local_gameScene').addClass("gameSceneCss");//添加样式
          $('#local_gameScene').toggleClass('gameSceneCss');*/

      },false);
  }

  // 使用道具
  var clickplayerinfo=function(){
    alert("使用的道具是"+propsName);
    if(propsName == 4){
                  noChanged  = true;     /*定身*/

              }else if(propsName == 5){
                  expedite()          /*加速*/

              }else if(propsName == 6){         /*减速*/
                  retard();

              }else if(propsName == 7){       /*重生图片    解除buff*/

              }else if(propsName == 8){   /*减去2行*/
                  game.cleanBoLine(2)

              }else if(propsName == 9){   /*减去1行*/
                  game.cleanBoLine(1)

              }else if(propsName == 10){      /*增加2行*/
                  game.addBotLine(generateBotLine(2))

              }else if(propsName == 11){           /*增加1行*/
                  game.addBotLine(generateBotLine(1))

              }
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

  // 移动
  var move = function () {
    timeFunc();
    /*  var scoreMsg = {};
      scoreMsg.type = "score"
      scoreMsg.msgStr = game.score;*/
  //    console.log("game.scoreDiv.innerHTML=="+game.score)
    if (!game.down()) {
        game.fixed();

    if(noChanged){
        if(noChangedBlock ==1 ){
            noChanged = false;
            noChangedBlock = 0;
        }else{
            noChangedBlock++;
        }

    }
      var line = game.checkClear();
        console.log("game.stage_arr.lenth===="+game.stage_arr.length)
      if (line) {
        game.addScore(line);  /*随机获取道具*/
          var scoreMsg = {};
          scoreMsg.type = "score"
          scoreMsg.msgStr = game.score;
          console.log("game.scoreDiv.innerHTML=="+game.score)
         // socket.websocket.send(JSON.stringify(scoreMsg))
      }
      var gameOver = game.checkGameOver();
      if (gameOver) {
        game.onGameOver(false);
        stop();
        document.getElementById("result").style.display="block";
      } else {
        game.performNext(generateType(), generateDir());
      }
    }
  }
  var sec = function () {
      time += 1;
      game.setTime(time);
      if (time % 60 == 0) { // 60秒生成一行
        //  game.addBotLine(generateBotLine(1));
      }

  }
  // 随机生成干扰行
  var generateBotLine = function (lineNum) {
    var lines = [];
    for (var i = 0; i < lineNum; i++) {
      var line = [];
      for (var j = 0; j < 10; j++) {
          if(Math.random()*1>=0.45){
              line.push(0)
          }else{
              line.push(-1);
          }
  //      line.push(Math.ceil(Math.random() * (-2)) + 1); // 生成 0 1 随机数
      }
      lines.push(line);
    }
    return lines;
  }
  // 计时函数
  var timeFunc = function () {
    timeCount += 1;
  /*  if (timeCount == 5) {
      timeCount = 0;
      time += 1;
      game.setTime(time);
      if (time % 10 == 0) { // 60秒生成一行
        game.addBotLine(generateBotLine(1));
      }
    }*/
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
      clearInterval(sec_1);
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
      scoreDiv: document.getElementById('scoreMe'),
      resultDiv: document.getElementById('local_gameover'),
      stage2_num: document.getElementById('stage2_num'),
    }
    console.log("gameDiv===="+doms.gameDiv.offsetWidth)

    game = new Game();
  //  socket = new Socket("ws://thdd.apexgame.cn/tetris/websocket1");
    game.init(doms, generateType(), generateDir());
    bindKeyEvent(doms);
    game.performNext(generateType(), generateDir());
    timer = setInterval(move, INTERVAL);
    sec_1 = setInterval(sec, 1000);
  }

  this.start = start;
  this.clickplayerinfo=clickplayerinfo;
}