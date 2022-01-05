var vm = new Vue({
    el:'#update',
    data:{
        school:[],
        player:{},
        team:[],
        imgaddress:''
    },
    methods:{
        chushihua:function (id) {
            var _this = this;
            axios.post("/player/selectSchool").then(function (response) {
                _this.school = response.data;
            })
            axios.post("/player/selectTeam").then(function (response) {
                _this.team = response.data;
            })
            axios.post("/player/selectById?id="+id).then(function (response) {
                _this.player = response.data;
                _this.imgaddress = response.data.url;
            })
        },
        updatePlayer:function () {
            var _this = this;
            axios.post("/player/updatePlayer",_this.player).then(function (response) {
                if(response.data.flag){
                    alert(response.data.msg);
                    location.href="/main/toindex";
                }else{
                    alert(response.data.msg);
                }
            })
        },
        upload:function () {
            var formData = new window.FormData;
            formData.append('file',document.querySelector('input[type=file]').files[0]);
            var options={
                url: '../player/fileUpload',
                data: formData,
                method: 'post',
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            };
            var _this = this;
            axios(options).then(function (response) {
                if(response.data.flag){

                    _this.imgaddress = response.data.imgaddress;

                    alert(response.data.msg);
                }else {
                    alert(response.data.msg);
                }
            })
        }
    }
});
vm.chushihua();