#!/bin/bash

# 오늘 날짜 (yy-mm-dd)
today=$(date +%y-%m-%d)

# 플랫폼 입력 (BOJ, SWEA, PRO)
read -p "플랫폼 입력 (BOJ/SWEA/PRO): " platform

# 문제 번호 입력
read -p "문제 번호 (예: 1234): " number

# 상태 입력 (solved / unsolved / refactor 등)
read -p "상태 입력 (solved/unsolved/refactor): " status

# 메시지 생성
message="[$today] $platform $number : $status"

# git add + commit 실행
git add .
git status
git commit -m "$message"
git push
