var Game = function () {
    // dom元素
    var gameDiv;
    var nextDiv;
    var timeDiv;
    var scoreDiv;
    var resultDiv;
    var stage2_num;
    var stage_arr = [];
    


    // 行数
    var line=0;

    // 分数
    var score = 0;
    var stage2num = 0;

    var orDown = false;

    var d_a = false;
    var d_b = false;

    var na;
    var nb;

    // 游戏矩阵
    var gameData = [
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],

        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],



    ];

    // 当前方块
    var cur;
    // 下一个方块
    var next;
    // divs
    var nextDivs = [];
    var gameDivs = [];

    var b = 0;

    // 方块移动到底部 固定
    var fixed = function() {
        for (var i=0; i<cur.data.length; i++) {
            for (var j=0; j<cur.data[0].length; j++) {
                if (check(cur.origin, i, j)) {
                    if (gameData[cur.origin.x + i][cur.origin.y + j] == 2) {
                        b = Math.random()*10;
                        if(b>9.6){
                            gameData[cur.origin.x + i][cur.origin.y + j] = 10;
                        }else if(b>9.2){
                            gameData[cur.origin.x + i][cur.origin.y + j] = 9;
                        }else if(b>8.9){
                            gameData[cur.origin.x + i][cur.origin.y + j] = 8;
                        }else if(b>8.6){
                            gameData[cur.origin.x + i][cur.origin.y + j] = 7;
                        }else if(b>8.3){
                            gameData[cur.origin.x + i][cur.origin.y + j] = 6;
                        }else if(b>7.9){
                            gameData[cur.origin.x + i][cur.origin.y + j] = 5;
                        }else if(b>7.6){
                            gameData[cur.origin.x + i][cur.origin.y + j] = 4;
                        }else if(b>7.2){
                            gameData[cur.origin.x + i][cur.origin.y + j] = 11;
                        } else{
                            gameData[cur.origin.x + i][cur.origin.y + j] = 1;
                        }

                    }
                }
            }
        }
        refreshDiv(gameData, gameDivs,cur.colorStyle);
    }

    // 初始化div
    var initDiv = function (container, data, divs) {
        for (var i=0; i<data.length; i++) {
            var div = [];
            console.log("hhhhh")
            for (var j=0; j<data[0].length; j++) {
                var newNode = document.createElement('div');
                console.log("gameDiv===="+container.offsetWidth)
                newNode.className = 'none';
                //   newNode.style.top = (i*itemWidth/10)+'px';
                newNode.style.top = (i*(container.offsetHeight/21))+'px';
                newNode.style.left = (j*(container.offsetWidth/10))+'px';
                newNode.style.width = (container.offsetWidth/10)+ 'px';
                newNode.style.height = (container.offsetHeight/21)+ 'px';
                //      newNode.style.left = (j*itemWidth/10)+'px';
                //  newNode.style.color = 'blue';
                console.log("ggggggggggg")
                container.appendChild(newNode);
                div.push(newNode);
            }
            divs.push(div);
        }
    }

    var initDiv0 = function (container, data, divs) {
        for (var i=0; i<data.length; i++) {
            var div = [];
            console.log("hhhhh")
            for (var j=0; j<data[0].length; j++) {
                var newNode2 = document.createElement('div');
                //   newNode.style.top = (i*itemWidth/10)+'px';
                newNode2.style.top = (i*(container.offsetHeight/4))+'px';
                newNode2.style.left = (j*(container.offsetWidth/4))+'px';
                newNode2.style.width = (container.offsetWidth/4)+ 'px';
                newNode2.style.height = (container.offsetHeight/4)+ 'px';
         //       newNode2.style.backgroundImage =  'url("../img/sprite2.png")';
                //    newNode.style.marginBottom = 5+"px";
                //      newNode.style.left = (j*itemWidth/10)+'px';
                //  newNode.style.color = 'blue';
                console.log("ggggggggggg")
                container.appendChild(newNode2);
                div.push(newNode2);
            }
            divs.push(div);
        }
    }

    // 刷新div
    var refreshDiv = function (data, divs, colorStyle) {
        for (var i=0; i<data.length; i++) {
            for (var j=0; j<data[0].length; j++) {
                if (data[i][j] == 0) {
                    divs[i][j].className = 'none';
                } else if(data[i][j] == 1){
                    divs[i][j].className = 'done';

                }else if (data[i][j] == 2) {                   /*这个*/
     //               divs[i][j].className = 'current';
                    if(colorStyle == 1){
                        divs[i][j].className = 'current1'
                    }else if(colorStyle == 2){
                        divs[i][j].className = 'current2'

                    }else if(colorStyle == 3){
                        divs[i][j].className = 'current3'
                    } else if(colorStyle == 4){
                        divs[i][j].className = 'current1'

                    }else if(colorStyle == 5){
                        divs[i][j].className = 'current2'

                    }else if(colorStyle ==6 ){
                        divs[i][j].className = 'current2'

                    }else if(colorStyle == 7){
                        divs[i][j].className = 'current3'
                    }
                } else if(data[i][j] == 11){       /*道具*/
                    console.log("dao局局  哈吉斯不嗲BFS")
                    divs[i][j].className = 'dj8';
                }else if(data[i][j] == 4){
                    divs[i][j].className = 'dj1';
                }else if(data[i][j] == 5){
                    divs[i][j].className = 'dj2';
                }else if(data[i][j] == 6){
                    divs[i][j].className = 'dj3';
                }else if(data[i][j] == 7){
                    divs[i][j].className = 'dj4';
                }else if(data[i][j] == 8){
                    divs[i][j].className = 'dj5';
                }else if(data[i][j] == 9){
                    divs[i][j].className = 'dj6';
                }else if(data[i][j] == 10){
                    divs[i][j].className = 'dj7'
                }else if(data[i][j] == -1){
                    divs[i][j].className = 'dj9'      /*黑色的方块*/
                }
            }
        }
    }

    // 刷新div
    var refreshAdd = function (data, divs) {
        for (var i=0; i<data.length; i++) {
            for (var j=0; j<data[0].length; j++) {
                if (data[i][j] == 0) {
                    divs[i][j].className = 'none';
                } else if(data[i][j] == 1){
                    //             divs[i][j].className = 'done';
                    console.log("8uuhjjuihjhjhkjkjknjk")

                    if(data[i][j].colorStyle == 1){
                        divs[i][j].className = 'current1'
                    }else if(data[i][j].colorStyle == 2){
                        divs[i][j].className = 'current2'

                    }else if(data[i][j].colorStyle == 3){
                        divs[i][j].className = 'current3'
                    } else if(data[i][j].colorStyle == 4){
                        divs[i][j].className = 'current1'

                    }else if(data[i][j].colorStyle == 5){
                        divs[i][j].className = 'current2'

                    }else if(data[i][j].colorStyle ==6 ){
                        divs[i][j].className = 'current2'

                    }else if(data[i][j].colorStyle == 7){
                        divs[i][j].className = 'current3'
                    }

                }/*else if (data[i][j] == 2) {                   /!*这个*!/
                    //               divs[i][j].className = 'current';
                    if(colorStyle == 1){
                        divs[i][j].className = 'current1'
                    }else if(colorStyle == 2){
                        divs[i][j].className = 'current2'

                    }else if(colorStyle == 3){
                        divs[i][j].className = 'current3'
                    } else if(colorStyle == 4){
                        divs[i][j].className = 'current1'

                    }else if(colorStyle == 5){
                        divs[i][j].className = 'current2'

                    }else if(colorStyle ==6 ){
                        divs[i][j].className = 'current2'

                    }else if(colorStyle == 7){
                        divs[i][j].className = 'current3'
                    }
                }*/ else if(data[i][j] == 11){       /*道具*/
                    console.log("dao局局  哈吉斯不嗲BFS")
                    divs[i][j].className = 'dj8';
                }else if(data[i][j] == 4){
                    divs[i][j].className = 'dj1';
                }else if(data[i][j] == 5){
                    divs[i][j].className = 'dj2';
                }else if(data[i][j] == 6){
                    divs[i][j].className = 'dj3';
                }else if(data[i][j] == 7){
                    divs[i][j].className = 'dj4';
                }else if(data[i][j] == 8){
                    divs[i][j].className = 'dj5';
                }else if(data[i][j] == 9){
                    divs[i][j].className = 'dj6';
                }else if(data[i][j] == 10){
                    divs[i][j].className = 'dj7'
                }else if(data[i][j] == -1){
                    divs[i][j].className = 'dj9'      /*黑色的方块*/
                }
            }
        }
    }

    // 检测点是否合法
    var check = function (pos, x, y) {
       /* if (pos.x + x < 0) {
            return false;
        } else if (pos.x + x >= gameData.length) {
            return false;
        } else if (pos.y + y < 0) {
            return false;
        } else if (pos.y + y >= gameData[0].length) {
            return false;
        } else if (gameData[pos.x + x][pos.y + y] === 1 || gameData[pos.x + x][pos.y + y] === 3) {
            return false;
        } else {
            return true;
        }*/

/*
       if(row){
           if (pos.x + x < 0) {
               return false;
           } else if (pos.x + x >= gameData.length+2) {
               return false;
           } else if (pos.y + y < 0) {
               return false;
           } else if (pos.y + y >= gameData[0].length +2) {
               return false;
           } else if (gameData[pos.x + x][pos.y + y] === 1 || gameData[pos.x + x][pos.y + y] === 3) {
               return false;
           } else {
               return true;
           }
       }else{*/
           if (pos.x + x < 0) {
               return false;
           } else if (pos.x + x >= gameData.length) {
               return false;
           } else if (pos.y + y < 0) {
               return false;
           } else if (pos.y + y >= gameData[0].length) {
               return false;
           } else if (gameData[pos.x + x][pos.y + y] === 1 || gameData[pos.x + x][pos.y + y] === 11 ||
               gameData[pos.x + x][pos.y + y] === 4 || gameData[pos.x + x][pos.y + y] === 5|| gameData[pos.x + x][pos.y + y] === 6
           ||gameData[pos.x + x][pos.y + y] === 7||gameData[pos.x + x][pos.y + y] === 8||gameData[pos.x + x][pos.y + y] === 9||
               gameData[pos.x + x][pos.y + y] === 10 || gameData[pos.x + x][pos.y + y] === -1) {
               return false;
           } else {
               return true;
           }
   //    }



    }

    // 检测数据是否合法
    var isValid = function(pos, data) {
        for (var i = 0; i < data.length; i++) {
            for (var j = 0; j < data[0].length; j++) {
                if (data[i][j] != 0) {
                    if (!check(pos, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // 清除数据
    var clearData = function () {
        for (var i=0; i<cur.data.length; i++) {
            for (var j=0; j<cur.data[0].length; j++) {
                if (check(cur.origin, i, j)) {
                    gameData[cur.origin.x + i][cur.origin.y + j] = 0;
                }
            }
        }
    }
    var a  = 0;
    // 设置数据
    var setData = function () {
        for (var i=0; i<cur.data.length; i++) {
            for (var j=0; j<cur.data[0].length; j++) {
                if (check(cur.origin, i, j)) {
/*
                    if(!orDown){
                        a = Math.random()*10
                        if(a>7){
                            if(cur.data[i][j] == 2){
                                console.log("就不会健康环保健康环保健康和vuhgcfyuicuyjk")
                                cur.data[i][j] = 3;

                                console.log("gameData[cur.origin.x + i][cur.origin.y + j]======"+ cur.data[i][j])
                            }

                        }
                    }*/

                    gameData[cur.origin.x + i][cur.origin.y + j] = cur.data[i][j];
                    console.log("cur.origin.y===="+ cur.origin.y)


                }
            }
        }
    }

    // 旋转
    var rotate = function () {
        if (cur.canRotate(isValid)) {
            clearData();
            cur.rotate();
            orDown = true;
            setData();
            orDown = false;
            refreshDiv(gameData, gameDivs, cur.colorStyle);
        }
    }


    // 下移
    var down = function () {
        if (cur.canDown(isValid)) {
            clearData();
            cur.down();
            orDown = true;
            setData();
            orDown = false;
            refreshDiv(gameData, gameDivs, cur.colorStyle);
            return true;
        } else {
            return false;
        }
    }

    // 左移
    var left = function () {
        if (cur.canLeft(isValid)) {
            clearData();
            cur.left();
            orDown = true
            setData();
            orDown = false;
            refreshDiv(gameData, gameDivs, cur.colorStyle);
        }
    }

    // 右移
    var right = function () {
        if (cur.canRight(isValid)) {
            clearData();
            cur.right();
            orDown = true;
            setData();
            orDown = false;
            refreshDiv(gameData, gameDivs,cur.colorStyle);
        }
    }

    // 发送玩家数据
        function sendGamesMessage() {
            var playMessage = {};
            playMessage.type = "removeLines"
            playMessage.roomId = roomId;//房间id
            playMessage.toUserName = "";//道具攻击人
            playMessage.fromUserName = "";//道具发起人
            playMessage.msgStr = "";//弹幕
            playMessage.userStatus = userStatus;//玩家状态
            playMessage.roomState = roomState;
            playMessage.position = "1";
            playMessage.headimgurl = img;//头像
            playMessage.nicakname = nicakname;//玩家姓名
            playMessage.sex = sex;
            playMessage.city = city;
            playMessage.userId = userId;//userId
            playMessage.propsName = "";//道具名称  
            playMessage.isSelf = "";
            playMessage.getOnclient = "";
            playMessage.ownerImg = "";
            playMessage.imgOne = document.getElementById("headImg1").src;
            playMessage.imgTwo = document.getElementById("headImg2").src;
            playMessage.imgThree = document.getElementById("headImg3").src;
            playMessage.imgFour = document.getElementById("headImg4").src;
            playMessage.score = score;//分数
            playMessage.lines = line;//行数
            playMessage.count = 0;//道具使用次数
            playMessage.propsStatus = 0;
            alert("发送消除行数分数请求！"+"||发送的分数：："+score+"||发送的行数：："+line);
            websocket.send(JSON.stringify(playMessage));
        }

    var c = 0;
    // 消行
    var checkClear = function () {
        
        for (var i=gameData.length-1; i>=0; i--) { // 反过来遍历
            var clear = true;
            for (var j=0; j<gameData[0].length; j++) { // 判断一行是否可以清除
                if (gameData[i][j] != 1 && gameData[i][j] != 11 && gameData[i][j] != 4&& gameData[i][j] != 5 && gameData[i][j] != 6
                    && gameData[i][j] != 7 && gameData[i][j] != 8 && gameData[i][j] != 9 && gameData[i][j] != 10 && gameData[i][j] != -1) {
                    clear = false;
                    break;
                }
            }
            if (clear) {
                line++;
                sendGamesMessage();
                loadstart1();

                for(var k = 0; k<gameData[0].length; k++){
                    if(gameData[i][k] != 1){
                        c++;
                        stage_arr.push(gameData[i][k]);
                    }
                }
                if(this.d_a == false){
                    console.log("njisadhvisa b333333333")
                    if(stage_arr[0]){
                        var dj_a = document.getElementById("stage1")
                        na = stage_arr[0]
                        this.na = na;
                        dj_a.src = "../img/a/dj"+(na-3)+".png";
                        stage_arr.splice(0,1);
                        console.log("var na = this.stage_arr[0]===道具是道具师道具师"+stage_arr[0])
                        d_a = true;
                        this.d_a = d_a;
                    }

                }

                if(this.d_b == false){
                    console.log("尔特温柔提问人头")
                    if(stage_arr[0]){
                        var dj_b = document.getElementById("stage2");
                        nb = stage_arr[0];
                        this.nb = nb;
                        dj_b.src= "../img/a/dj"+(nb-3)+".png";
                        stage_arr.splice(0,1);
                        console.log("var nb = this.stage_arr[0]"+stage_arr[0])
                        d_b = true;
                        this.d_b = d_b;
                    }
                }
                this.stage_arr = stage_arr;
                stage_arr = [];
                this.stage_arr = [];
                console.log("ccccccccccccccccccccccc======"+c)


                c = 0;
                for (var m=i; m>0; m--) {
                    for (var n=0; n<gameData[0].length; n++) {
                        gameData[m][n] = gameData[m-1][n];
                    }
                }
                for (var n=0; n<gameData[0].length; n++) {
                    gameData[0][n] = 0;
                }
                i++;
                
            }
            
        }
        console.log("stage_arr================"+this.stage_arr.length);
        console.log("消了"+line+"行");
        return line;
        
    }
    
    // 进度条
    function loadstart1(){
                var pg=document.getElementById("pg1");
                var i=0;
                i+=1;
                pg.value=i;   
            }

    // 检查游戏结束
    var checkGameOver = function () {
        var gameOver = false;
        for (var i=0; i<gameData[0].length; i++) {
            if (gameData[1][i] == 1) {
                gameOver = true;
            }else if(line>2){
                gameOver = true;
            }
        }
        return gameOver;
    }

    // 使用下一个方块
    var performNext = function (type, dir) {
        cur = next
        setData();
        next = SquareFactory.prototype.make(type, dir);
        refreshDiv(gameData, gameDivs, cur.colorStyle);
        refreshDiv(next.data, nextDivs, next.colorStyle);
    }

    // 设置时间
    var setTime = function (time) {
        timeDiv.innerHTML = time;
    }

    // 加分
    var addScore = function (line) {
        var s = 0;
        switch (line) {
            case 1:
                s = 10;
                /*随机获取道具*/
                console.log("随机获取道具-------");
                console.log("Math.random()"+Math.random() * 10);
                if(Math.random() * 10>1.6){
                    if(Math.random() * 10>8.2){
                        stage2num+=2;
                    }else{
                        stage2num+=1;
                    }
                    stage2_num.innerHTML = stage2num;

                }
                console.log("stage2_num.innerHTML"+stage2_num.innerHTML)


                break;
            case 2:
                s = 30;
                if(Math.random() * 10>3){
                    if(Math.random() * 10>7.2){
                        stage2num+=2;
                    }else{
                        stage2num+=1;
                    }
                    stage2_num.innerHTML = stage2num;
                }
                console.log("stage2_num.innerHTML"+stage2_num.innerHTML)
                break;
            case 3:
                s = 60;
                if(Math.random() * 10>2){
                    if(Math.random() * 10>4.4){
                        stage2num+=2;
                    }else{
                        stage2num+=1;
                    }

                    stage2_num.innerHTML = stage2num;

                }
                console.log("stage2_num.innerHTML"+stage2_num.innerHTML)
                break;
            case 4:
                s = 100;
                if(Math.random() * 10>1.2){
                    if(Math.random() * 10>3.1){
                        stage2num+=2;
                    }else{
                        stage2num+=1;
                    }
                    stage2_num.innerHTML = stage2num;
                }
                console.log("stage2_num.innerHTML"+stage2_num.innerHTML)
                break;
            default:
                break;
        }
        this.stage = stage2num;
        score += s;
        // scoreDiv.innerHTML = score;
        this.score = score;
        // console.log("scoreDiv.innerHTML"+scoreDiv.innerHTML);
        console.log("分数"+score);
    }

    // 游戏结束
    var onGameOver = function (win) {
        alert("游戏结束"+line);
        if (win) {
            resultDiv.innerHTML = '你赢了';
        } else {
             $("#canvas1").show();
            $("#re_btn").show();
            //     resultDiv.innerHTML = '游戏结束';
            var can1 = document.getElementById("canvas1")//fishes  dust ui circle  20px Verdana
            var ctx1 = can1.getContext('2d');
           
            document.getElementById("canvas1").width = 320;
            document.getElementById("canvas1").height = 468;
            ctx1.font = "27px Verdana";
            ctx1.textAlign = "center";
        
            var w = can1.width;
            var h = can1.height;
            console.log("khhhhh666666666666666666666")

            ctx1.save();
           
            /*ctx1.lineWidth = 20;*/
            ctx1.shadowBlur = 20;
            ctx1.shadowColor = "white";
            ctx1.fillStyle = "white";
           
            //   ctx1.fillStyle = "rgba(255,255,255,"+0.9+")";
            ctx1.fillText("GAMEOVER",w/2,h/2);
            
            /*ctx1.fillText("num ",100,h-50);
             ctx1.fillText("double ",w*0.5,h-80);
             ctx1.fillText("score ",w/2,h-20);*/
            ctx1.restore();
           
            restart();


            // to_over=setInterval(to_over,3000);
        }
    }
    re_btn.onclick=function(){
        
        $("#canvas1").hide();
        $("#re_btn").hide();
        var local = new Local();
        local.start();
        
        
        
    }
    // 跳转结果页
    var to_over=function(){
        window.location.href="http://thdd.apexgame.cn/tetris/skip/oversend"
    }

    // 重新开始游戏
    var restart=function(){
        var butdiv=document.createElement("p");
         var re_btn = document.getElementById("re_btn");
         re_btn.appendChild(butdiv);
         butdiv.setAttribute("id","restart_btn");
         butdiv.innerHTML="重新开始";
         butdiv.style.width="320px";
         butdiv.style.height="468px";
         butdiv.style.color="white";
         butdiv.style.fontSize="27px";
         butdiv.style.textAlign="center";

    }


    // 底部增加行
    var addBotLine = function (lines) {
        for (var i=0; i<gameData.length - lines.length; i++) { // 行上移
            gameData[i] = gameData[i + lines.length];
        }
        for (var i=0; i<lines.length; i++) {
            gameData[gameData.length - lines.length + i] = lines[i];
            console.log("gameData[gameData.length - lines.length + i]"+gameData[gameData.length - lines.length + i])
        }
        cur.origin.x = cur.origin.x - lines.length;
        if (cur.origin.x < 0) {
            cur.origin.x = 0;
        }
        refreshDiv(gameData, gameDivs);
      //  refreshAdd(gameData, gameDivs)
    }

    var cleanBoLine = function (num) {

        for (var i=gameData.length-1; i>=gameData.length-num; i--) { // 反过来遍历
            for (var m=gameData.length-1; m>0; m--) {
                for (var n=0; n<gameData[0].length; n++) {
                    gameData[m][n] = gameData[m-1][n];
                }
            }
            for (var n=0; n<gameData[0].length; n++) {
                gameData[0][n] = 0;
            }
            cur.origin.x = cur.origin.x+1;
            if(cur.origin.x>gameData.length-1){
                cur.origin.x = gameData.length-1

            }
        }

        refreshDiv(gameData, gameDivs);

        /* /!*  cur.origin.x = cur.origin.x+2;
         if (cur.origin.x >=  gameData.length-1) {
         cur.origin.x = gameData.length -1;
         }*!/*/

        /*    for (var m=gameData.length -1; m>=2; m--) {
         //    for (var n=0; n<gameData[0].length; n++) {
         gameData[m] = gameData[m-2]
         //      }
         }
         for (var n=0; n<gameData[0].length; n++) {
         gameData[0][n] = 0;
         gameData[1][n] = 0;
         }
         /!*  cur.origin.x = cur.origin.x+2;
         if (cur.origin.x >=  gameData.length-1) {
         cur.origin.x = gameData.length -1;
         }*!/
         console.log("jjjj")

         refreshDiv(gameData, gameDivs);*/



        /*    for (var m=gameData.length -1; m>0; m--) {
         for (var n=0; n<gameData[0].length; n++) {
         gameData[m][n] = gameData[m-1][n];
         }
         }
         for (var n=0; n<gameData[0].length; n++) {
         gameData[0][n] = 0;
         }*/
    }
    var f = 0;
    var speed = function () {
        while(f<5){
            down()
            f++
        }
        f=0
    }

    // 初始化函数
    var init = function (doms, type, dir) {
        gameDiv = doms.gameDiv;
        nextDiv = doms.nextDiv;
        timeDiv = doms.timeDiv;
        scoreDiv = doms.scoreDiv;
        resultDiv = doms.resultDiv;
        stage2_num = doms.stage2_num;
        next = SquareFactory.prototype.make(type, dir);
        initDiv(gameDiv, gameData, gameDivs);
        initDiv0(nextDiv, next.data, nextDivs);
        refreshDiv(next.data, nextDivs, next.colorStyle);
    }

    // 导出API
    this.init = init;
    this.down = down;
    this.left = left;
    this.right = right;
    this.rotate = rotate;
 //   this.fall = function () {while(down());};

    this.fall = speed;
    this.fixed = fixed;
    this.performNext = performNext;
    this.checkClear = checkClear;
    this.checkGameOver = checkGameOver;
    this.showPlayerInfo=showPlayerInfo;
    this.setTime = setTime;
    this.addScore = addScore;
    this.onGameOver = onGameOver;
    this.addBotLine = addBotLine;
    this.cleanBoLine = cleanBoLine;
    this.stage = stage2num;         /*两个必须填写*/
    this.scoreDiv = scoreDiv;
    this.score = score;
    this.stage_arr = stage_arr;
    this.d_a = d_a;
    this.d_b = d_b;
    this.na = na;
    this.nb = nb;
    this.refreshAdd = refreshAdd;
}