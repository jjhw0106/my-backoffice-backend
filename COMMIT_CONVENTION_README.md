## GPT를 이용한 Commit 작성
- git add . 시 작업한 변경 내용을 GPT에 보내서 커밋 메시지 형태로 return 받아옴
- git commit시, 받아온 커밋 내용을 사용하여 메시지 작성.

**주요 흐름** 
1. `git add .` 실행 → `git diff --cached` 내용을 전달 받음    
    `git diff --cached` 결과를 GPT에게 전달    
2. GPT가 diff 내용을 분석해 의미 있는 커밋 메시지를 반환
3. 커밋 메시지를 수동/자동으로 적용
   
전체 내용 정리 Notion : https://www.notion.so/GPT-Git-1d9ff87732fe807b999cc6d98d39231e
