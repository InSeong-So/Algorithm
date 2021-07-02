function isPrime(num) {
  num = num || 0;
  if (num === 1 || num === 0) return false;
  // 루트 N까지 확인하기 : 약수의 중심을 구하는 방법
  // 약수들의 곱 = 루트 N의 값, 즉 중간값으로 중간 값 이전까지 확인하면 이후는 필요없다.
  for (let i = 2; i * i <= num; i++) {
    if (num % i === 0) return false;
  }
  return true;
}

console.log(isPrime(null));

module.exports = isPrime;
