'use strict';

const fs = require('fs');
// import solution js file
const solution = require('');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function (inputStdin) {
  inputString += inputStdin;
});

process.stdin.on('end', function () {
  inputString = inputString.split('\n');

  main();
});

function readLine() {
  return inputString[currentLine++];
}

// TODO solution code

function main() {
  const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

  let s = Array(3);

  for (let i = 0; i < 3; i++) {
    s[i] = readLine()
      .replace(/\s+$/g, '')
      .split(' ')
      .map(sTemp => parseInt(sTemp, 10));
  }

  const result = solution();

  ws.write(result + '\n');

  ws.end();
}
