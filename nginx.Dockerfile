FROM nginx:latest
# 가상 공간의 nginx 기본 설정파일 삭제 후 작성한 설정파일로 대체
COPY nginx.conf /etc/nginx/conf.d