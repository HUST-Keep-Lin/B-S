<template>
  <div>
    <div>
      <el-card class="box-card">
        <div class="img_box">

          <img id="map_img" src="../Map.jpg" width="90%" height="90%">

          <div class="word" />
          <div v-for="(item, index) in mockData['x预测']" v-show="checkedPre" :key="`1-${index}`.toString()">
            <HoverDot :data="getItemInMockDataPre(index)" background-color:black />
          </div>
          <div v-for="(item, index) in mockData.x" v-show="checkedPosition" :key="`2-${index}`.toString()">
            <HoverDot2 :data="getItemInMockDataPosition(index)" />
          </div>
          <div v-for="(item, index) in mockData.xt" v-show="checkedTruth" :key="`3-${index}`.toString()">
            <HoverDot3 :data="getItemInMockDataTruth(index)" />
          </div>
        </div>
      </el-card>

    </div>

    <div>
      <el-card>
        <el-checkbox v-model="checkedPre">预测路径</el-checkbox>
        <el-checkbox v-model="checkedPosition">定位路径</el-checkbox>
        <el-checkbox v-model="checkedTruth">真实路径</el-checkbox>
      </el-card>
    </div>
  </div>
</template>

<script>
import HoverDot from '@/components/HoverDot'
import HoverDot2 from '@/components/HoverDot2'
import HoverDot3 from '@/components/HoverDot3'
import { GetData } from '@/api/userApi'
export default {
  components: {
    HoverDot,
    HoverDot2,
    HoverDot3
  },
  data() {
    return {
      checkedPre: false,
      checkedPosition: false,
      checkedTruth: true,
      mockData: {
        x: [],
        y: [], // x和y代表卫星定位坐标，position
        accx: [],
        accy: [],
        accz: [], // accx,accy,accz代表三轴加速度
        gyroscopex: [],
        gyroscopey: [],
        gyroscopez: [], // gyroscopex,gyroscopey,gyroscopez代表三轴角加速度
        'x预测': [],
        'y预测': [], // 预测的坐标
        xt: [],
        yt: [], // 真实的坐标
        '航向': [], // 航向角度
        'error': [] // 每个点对应和真实点之间的误差
      }
    }
  },
  created() {
    this.getData()
  },
  methods: {
    getData() {
      GetData().then(response => {
        console.log(response)
        this.mockData.x = response['x']
        this.mockData.y = response['y']
        this.mockData.accx = response['accx']
        this.mockData.accy = response['accy']
        this.mockData.accz = response['accz']
        this.mockData.gyroscopex = response['gyroscopex']
        this.mockData.gyroscopey = response['gyroscopey']
        this.mockData.gyroscopez = response['gyroscopez']
        this.mockData.xt = response['xt']
        this.mockData.yt = response['yt']
        this.mockData.x预测 = response['xr']
        this.mockData.y预测 = response['yr']
        this.mockData.航向 = response['arg']
        this.mockData.error = response['error']
      })
    },
    getItemInMockDataPre(index) {
      return {
        accx: this.mockData.accx[index],
        accy: this.mockData.accy[index],
        accz: this.mockData.accz[index],
        gyroscopex: this.mockData.gyroscopex[index],
        gyroscopey: this.mockData.gyroscopey[index],
        gyroscopez: this.mockData.gyroscopez[index],
        xt: this.mockData.xt[index],
        yt: this.mockData.yt[index],
        'x预测': this.mockData['x预测'][index],
        'y预测': this.mockData['y预测'][index],
        '航向': this.mockData['航向'][index],
        'error': this.mockData['error'][index]
      }
    },
    getItemInMockDataPosition(index) {
      return {
        'xposition': this.mockData.x[index],
        'yposition': this.mockData.y[index]
      }
    },
    getItemInMockDataTruth(index) {
      return {
        'xtruth': this.mockData.xt[index],
        'ytruth': this.mockData.yt[index]
      }
    }
  }
}

</script>

<style>
.word {
  width: 10px;
  height: 10px;
  position: absolute;
  top: 52%;
  left: 34%;
  border-radius: 50%;
  background-color: crimson;
  border-top: solid red 8px;
}

.index {
  width: 6px;
  height: 6px;
  position: absolute;
  top: -425px;
  left: 394px;
  border-radius: 50%;
  background-color: crimson;
  border-top: solid red 8px;
}

.img_box {
  position: relative;
}
</style>
