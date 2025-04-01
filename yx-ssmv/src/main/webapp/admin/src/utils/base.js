const base = {
    get() {
                return {
            url : "http://localhost:8080/yx-ssmv/",
            name: "yx-ssmv",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/yx-ssmv/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "游戏攻略网站"
        } 
    }
}
export default base
