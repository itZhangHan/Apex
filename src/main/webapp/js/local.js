var Local = function () {
  // 游戏对象
  var game;
  // 时间间隔
  var INTERVAL = 800;

  // 定时器
  var timer = null;
  var sec_1 = null;

  // 时间计数器
  var time = 0;
  var timeCount = 0;

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
      var rotate = document.getElementById("btn_rotate");
      var left = document.getElementById("btn_left");
      var right = document.getElementById("btn_right");

      var down = document.getElementById("btn_down");
      var stage2 = document.getElementById("stage2");

      //    var friend = document.getElementById("friend");
   /*       // 触摸
      rotate.ontouchstart = function() {
              // 背景变绿
          console.log("鼠标按下=====================")
    //          this.style.backgroundColor = "green";
          }
          // 停止触摸
      rotate.ontouchend = function() {
          console.log("鼠标松开-------------")
       //   this.style.backgroundColor = "white";
      }*/
              // 还原白色

      rotate.onclick = function(){
          game.rotate();
      }
      left.onclick = function () {
          game.left();
      }

  /*  left.ontouchstart = function()(
        console.log("鼠标按下=====================")
    )*/
      right.onclick = function(){
        game.right();
      }
      down.onclick = function () {
        game.fall();
      }

    stage2.onclick = function () {
     console.log("gggggggggg----"+game.stage);
     if(game.stage>0){
       game.stage-=1;
       doms.stage2_num.innerHTML = game.stage;

       game.addBotLine(generateBotLine(1)); /*道具向别人使用*/
     }
     }
  }

  // 移动
  var move = function () {
    timeFunc();
    if (!game.down()) {
      game.fixed();
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
  var sec = function () {
      time += 1;
      game.setTime(time);
      if (time % 60 == 0) { // 60秒生成一行
          game.addBotLine(generateBotLine(1));
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
    sec_1 = setInterval(sec, 1000);
  }

  this.start = start;
}