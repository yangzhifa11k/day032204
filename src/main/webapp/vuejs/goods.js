var vm=new Vue({
    el:'#app', //表示当前vue对象接管了div区域
    data:{
        goodsList:[],
        goodsBean:{},
        proList:[],
        cityList:[],
        couList:[],
        searchEntity:{yema:0,pageSize:3},
        page:{}
    },
    methods:{
        paging:function(yema){
            this.searchEntity.yema=yema;
            this.findAll();
        },
        findAll:function(){
            var _this = this;
            var url ="findAll.do";
            axios.post(url,_this.searchEntity).then(function (response) {
                _this.goodsList=response.data.goodsList;
                _this.page = response.data.page;
            }).catch(function (err) {
                console.log(err)
            });
        },

        getCityName:function(arr,tid){
            if(arr!=null){
                for (var i = 0; i < arr.length; i++) {
                    if(arr[i].tid==tid){
                        return arr[i].cname;
                    }
                }
            }
        },
        changecou:function(event){
            var id = event.target.value;
            alert(id);
            couName = this.getCityName(this.couList,tid);
            alert(couName);
            this.goodsBean.gtype=proName+cityName+couName;
        },
        changecity:function(event){
            this.couList=[];
            var tid = event.target.value;
            cityName = this.getCityName(this.cityList,tid);
            this.goodsBean.gtype=proName+cityName;
            var url="getTypeListById.do?tid="+tid;
            var _this=this;
            axios.get(url).then(function (response) {
                _this.couList=response.data;
            }).catch(function (err) {
                console.log(err)
            });
        },
        changepro:function(event){
            this.cityList=[];
            this.couList=[];
            var tid = event.target.value;
            proName = this.getCityName(this.proList,tid);
            this.goodsBean.gtype=proName;
            var url="getTypeListById.do?tid="+tid;
            var _this=this;
            axios.get(url).then(function (response) {
                _this.cityList=response.data;
            }).catch(function (err) {
                console.log(err)
            });
        },
        getProList:function(){
            var url="getTypeListById.do?tid=1";
            var _this=this;
            axios.get(url).then(function (response) {
                _this.proList=response.data;
            }).catch(function (err) {
                console.log(err)
            });
        },
        addGoods:function(){

            document.getElementById("a2").style.display="block";
        },
        closeWin:function(){
            if(window.confirm("您确定要没保存之前关掉新增页面吗?")){
                document.getElementById("a2").style.display="none";
            }

        },
        saveGoods:function(){
            var url="saveGoods.do";
            var _this = this;
            axios.post(url,_this.goodsBean).then(function (response) {
                if(response.data.success){
                    _this.findAll();
                    document.getElementById("a2").style.display="none";
                }else{
                    alert(response.data.message);
                }
            }).catch(function (err) {
                console.log(err)
            });


        },
    },
    created:function () {
        this.findAll();
    }
});