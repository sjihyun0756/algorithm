#!/bin/bash

# 오늘 날짜 (yy-mm-dd 형식)
today=$(date +%y-%m-%d)

# === 플랫폼 선택 ===
echo "플랫폼을 선택하세요:"
select platform in BOJ SWEA PRO ETC; do
  case $platform in
    BOJ|SWEA|PRO|ETC ) break ;;
    * ) echo "유효한 번호를 선택해주세요." ;;
  esac
done

# === 문제 번호 입력 ===
read -p "문제 번호 (예: 1234): " number

# === 상태 선택 ===
echo "문제 상태를 선택하세요:"
select status in solved unsolved refactor; do
  case $status in
    solved|unsolved|refactor ) break ;;
    * ) echo "유효한 번호를 선택해주세요." ;;
  esac
done

# === 커밋 메시지 생성 ===
commit_msg="[$today] $platform $number : $status"

# === Git 실행 ===
echo "변경사항 staging 중..."
git add .

echo "커밋 메시지: $commit_msg"
git commit -m "$commit_msg"

echo ""
echo "현재 Git 상태:"
git status

echo ""
echo "push가 자동으로 실행되지 않았습니다."
echo "직접 push 하세요:"
