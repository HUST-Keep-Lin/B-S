<template>
  <div class="dashboard-container">
    <!-- <div class="dashboard-text">name: {{ name }}</div> -->
    <!-- <el-button type="primary" round >室内行人定位轨迹的校正方法与可视化系统</el-button> -->
    <h1>基于改进PDR算法的室内行人定位轨迹校正以及可视化系统的开发</h1>
    <br><br>
    <div style="text-align: right;">R&D By 陈艺文 林克鹏  乔佳斌  求昊杰</div>
    <br><br>
    <!-- <div style="text-align: right;font-size: 5px;">Support By </div> -->
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
      'name'
    ])
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
