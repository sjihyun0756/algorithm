#!/bin/bash

# 1. algo-commit.sh 실행 권한 부여
chmod +x ./algo-commit.sh

# 2. alias 등록 (이미 등록돼 있지 않은 경우에만)
if ! grep -Fxq "alias algogit='$(pwd)/algo-commit.sh'" ~/.bashrc
then
  echo "alias algogit='$(pwd)/algo-commit.sh'" >> ~/.bashrc
  echo "✅ alias 'algogit' 등록 완료!"
else
  echo "ℹ️ alias 'algogit' 이미 등록되어 있음"
fi

# 3. bashrc 적용
source ~/.bashrc
echo "🎉 이제 'algogit' 명령어를 사용할 수 있어요!"
