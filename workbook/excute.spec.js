const fs = require('fs');
const os = require('os');
const input = fs.readFileSync('dev/stdin').toString().trim().split(os.EOL);
const [R, C] = input[0].split(' ').map(e2 => +e2);
const matrix = input.slice(1).map(e => e.split(''));

const dx = [0, 0, 1, -1];
const dy = [-1, 1, 0, 0];
const visited = Array.from({ length: R + 1 }, () => Array.from({ length: C + 1 }, () => -1));

const setup = () => {
  for (let i = 0; i < R; i++) {
    for (let j = 0; j < C; j++) {
      if (matrix[i][j] === 'S') {
        [hedgehogX, hedgehogY] = [i, j];
      }
      if (matrix[i][j] === '*') {
        [waterX, waterY] = [i, j];
      }

      if (hedgehogX !== null && waterX !== null) break;
    }
  }
};

const BFS = (x, y) => {
  let queue = [x, y];
  while(queue){
    let lx, ly = queue.shift();
    for(let i = 0; i < 4; i++){
      const nx = lx + dx[i];
      const ny = ly + dy[i];
      const wx = waterX + dx[i];
    }
  }
}

let [hedgehogX, hedgehogY] = [null, null];
let [waterX, waterY] = [null, null];
setup();
visited[hedgehogX][hedgehogY] = 0;
visited[waterX][waterY] = 0;
console.log(BFS(hedgehogX, hedgehogY));