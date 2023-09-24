<template>
  <div>
    <el-row :gutter="12">
      <el-col :span="6">
        <el-card shadow="always">
          50%误差:{{ DataIndicator[0].toFixed(3) }}
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="always">
          75%误差:{{ DataIndicator[1].toFixed(3) }}
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="always">
          90%误差：{{ DataIndicator[2].toFixed(3) }}
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="always">
          平均定位误差：{{ DataIndicator[3].toFixed(3) }}
        </el-card>
      </el-col>
    </el-row>
    <div id="indicatorChart" style="height: 500%; width: 100%" />
  </div>
</template>

<script>
import * as echarts from 'echarts'
import { GetError } from '@/api/userApi'
export default {
  data() {
    return {
      DataIndicator: [],
      mockData: {
        x: [3.1415, 2, 3, 4, 5],
        y1: [2, 4, 6, 8, 10],
        y2: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20],
        y3: [3, 6, 9, 12, 15, 18, 21, 24, 27, 30]
        // y2和y3为测试数据，实际上只画出y1曲线
      }
    }
  },
  async mounted() {
    await this.getData()
    this.init()
  },
  methods: {
    async getData() {
      await GetError().then(response => {
        this.DataIndicator = response['perror']
        this.mockData.x = response['cdfx']
        this.mockData.y1 = response['cdfy']
      })
    },
    init() {
      const chartDom = document.getElementById('indicatorChart')
      const myChart = echarts.init(chartDom)

      const option = {
        tooltip: {
          trigger: 'axis',
          formatter: function(param) {
            // 第一组数据param[0]
            console.log(param)
            const domName = 'x: ' + `<span style="color: ;">${param[0].axisValue}</span>` + '<br>' + 'y: ' + `<span style="color: ;">${param[0].data}</span>`
            return domName + '<br>'
          }
        },
        legend: {
          data: ['CDF']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        // toolbox: {
        //   feature: {
        //     saveAsImage: {}
        //   }
        // },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: this.mockData.x
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: 'CDF',
            type: 'line',
            data: this.mockData.y1
          }
          // {
          //   name: '2',
          //   type: 'line',
          //   data: this.mockData.y2
          // },
          // {
          //   name: '3',
          //   type: 'line',
          //   data: this.mockData.y3
          // }
        ]
      }

      option && myChart.setOption(option)
    }
  }
}
</script>
