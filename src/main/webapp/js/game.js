var Game = function () {
    // dom元素
    var gameDiv;
    var nextDiv;
    var timeDiv;
    var scoreDiv;
    var resultDiv;
    var stage2_num;

    // 分数
    var score = 0;
    var stage2num = 0;

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

    // 方块移动到底部 固定
    var fixed = function() {
        for (var i=0; i<cur.data.length; i++) {
            for (var j=0; j<cur.data[0].length; j++) {
                if (check(cur.origin, i, j)) {
                    if (gameData[cur.origin.x + i][cur.origin.y + j] == 2) {
                        gameData[cur.origin.x + i][cur.origin.y + j] = 1;
                    }
                }
            }
        }
        refreshDiv(gameData, gameDivs);
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
                newNode.style.height = (container.offsetWidth/10)+ 'px';
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
                var newNode = document.createElement('div');
                console.log("gameDiv===="+container.offsetWidth)
                newNode.className = 'none';
                //   newNode.style.top = (i*itemWidth/10)+'px';
                newNode.style.top = (i*(container.offsetHeight/4))+'px';
                newNode.style.left = (j*(container.offsetWidth/4))+'px';
                newNode.style.width = (container.offsetWidth/4)+ 'px';
                newNode.style.height = (container.offsetHeight/4)+ 'px';
                //    newNode.style.marginBottom = 5+"px";
                //      newNode.style.left = (j*itemWidth/10)+'px';
                //  newNode.style.color = 'blue';
                console.log("ggggggggggg")
                container.appendChild(newNode);
                div.push(newNode);
            }
            divs.push(div);
        }
    }

    // 刷新div
    var refreshDiv = function (data, divs) {
        for (var i=0; i<data.length; i++) {
            for (var j=0; j<data[0].length; j++) {
                if (data[i][j] == 0) {
                    divs[i][j].className = 'none';
                } else if (data[i][j] == 1) {
                    divs[i][j].className = 'done';
                } else if (data[i][j] == 2) {
                    divs[i][j].className = 'current';
                    /*  var ran = Math.ceil(Math.random() * 9) - 1;
                     if(ran<3){
                     divs[i][j].className = 'current';
                     }
                     else if(ran<6){
                     divs[i][j].className = 'current1';
                     }
                     else {
                     divs[i][j].className = 'current2';
                     }*/
                }
            }
        }
    }

    // 检测点是否合法
    var check = function (pos, x, y) {
        if (pos.x + x < 0) {
            return false;
        } else if (pos.x + x >= gameData.length) {
            return false;
        } else if (pos.y + y < 0) {
            return false;
        } else if (pos.y + y >= gameData[0].length) {
            return false;
        } else if (gameData[pos.x + x][pos.y + y] === 1) {
            return false;
        } else {
            return true;
        }
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

    // 设置数据
    var setData = function () {
        for (var i=0; i<cur.data.length; i++) {
            for (var j=0; j<cur.data[0].length; j++) {
                if (check(cur.origin, i, j)) {
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
            setData();
            refreshDiv(gameData, gameDivs);
        }
    }

    // 下移
    var down = function () {
        if (cur.canDown(isValid)) {
            clearData();
            cur.down();
            setData();
            refreshDiv(gameData, gameDivs);
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
            setData();
            refreshDiv(gameData, gameDivs);
        }
    }

    // 右移
    var right = function () {
        if (cur.canRight(isValid)) {
            clearData();
            cur.right();
            setData();
            refreshDiv(gameData, gameDivs);
        }
    }

    // 消行
    var checkClear = function () {
        var line = 0;
        for (var i=gameData.length-1; i>=0; i--) { // 反过来遍历
            var clear = true;
            for (var j=0; j<gameData[0].length; j++) { // 判断一行是否可以清除
                if (gameData[i][j] != 1) {
                    clear = false;
                    break;
                }
            }
            if (clear) {
                line++;
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
        return line;
    }

    // 检查游戏结束
    var checkGameOver = function () {
        var gameOver = false;
        for (var i=0; i<gameData[0].length; i++) {
            if (gameData[1][i] == 1) {
                gameOver = true;
            }
        }
        return gameOver;
    }

    // 使用下一个方块
    var performNext = function (type, dir) {
        cur = next;
        setData();
        next = SquareFactory.prototype.make(type, dir);
        refreshDiv(gameData, gameDivs);
        refreshDiv(next.data, nextDivs);
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
                console.log("Math.random()"+Math.random() * 10)
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
        scoreDiv.innerHTML = score;
        console.log("scoreDiv.innerHTML"+scoreDiv.innerHTML)
    }

    // 游戏结束
    var onGameOver = function (win) {
        if (win) {
            resultDiv.innerHTML = '你赢了';
        } else {
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
        }
    }

    // 底部增加行
    var addBotLine = function (lines) {
        for (var i=0; i<gameData.length - lines.length; i++) { // 行上移
            gameData[i] = gameData[i + lines.length];
        }
        for (var i=0; i<lines.length; i++) {
            gameData[gameData.length - lines.length + i] = lines[i];
        }
        cur.origin.x = cur.origin.x - lines.length;
        if (cur.origin.x < 0) {
            cur.origin.x = 0;
        }
        refreshDiv(gameData, gameDivs);
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
        refreshDiv(next.data, nextDivs);
    }

    // 导出API
    this.init = init;
    this.down = down;
    this.left = left;
    this.right = right;
    this.rotate = rotate;
    this.fall = function () {while(down());};
    this.fixed = fixed;
    this.performNext = performNext;
    this.checkClear = checkClear;
    this.checkGameOver = checkGameOver;
    this.setTime = setTime;
    this.addScore = addScore;
    this.onGameOver = onGameOver;
    this.addBotLine = addBotLine;
    this.cleanBoLine = cleanBoLine;
    this.stage = stage2num;         /*两个必须填写*/
    this.scoreDiv = scoreDiv;
}