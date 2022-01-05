var vm = new Vue({
    el:'#app',
    data:{
        list:[],
        player:{},
        page:{},
        pageNum:1,
        pageSize:3
    },
    methods:{
        selectAll:function () {
            var _this = this;
            axios.post("/player/selectAll?pageNum="+_this.pageNum+"&pageSize="+_this.pageSize,_this.player).then(function (response) {
                _this.page = response.data;
                _this.list = response.data.list;
                _this.pageNum = response.data.pageNum;
            })
        },
        paging(pageNum){
            if(pageNum==0){
                pageNum=1;
            }
            this.pageNum = pageNum;
            this.selectAll();
        },
        del:function (id) {
            axios.post("/player/deleteById?id="+id).then(function (response) {
                if(response.data.flag){
                    alert(response.data.msg);
                    location.reload();
                }else {
                    alert(response.data.msg);
                }
            })
        },
        add:function () {
            location.href="/main/toadd"
        },
        update:function (id) {
            location.href="/main/toupdate?id="+id;
        }
    }
});
vm.selectAll();