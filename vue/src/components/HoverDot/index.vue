<template>
  <el-popover placement="top-start" width="200" trigger="hover">
    <div>accx: {{ data.accx / 16384 }}</div>
    <div>accy: {{ data.accy / 16384 }}</div>
    <div>accz: {{ data.accz / 16384 }}</div>
    <div>gyroscopex: {{ data.gyroscopex }}</div>
    <div>gyroscopey: {{ data.gyroscopey }}</div>
    <div>gyroscopez: {{ data.gyroscopez }}</div>
    <div>x预测: {{ data['x预测'] }}</div>
    <div>y预测: {{ data['y预测'] }}</div>
    <div>航向: {{ data['航向'] }}°</div>
    <div>error: {{ data['error'] }}</div>
    <div slot="reference" class="chart_dot" :style="{ top: `${top}`, left: `${left}` }" />
  </el-popover>
</template>

<script>
export default {
  props: {
    data: {
      type: Object,
      default: () => { }
    }
  },
  computed: {
    top() {
      return `calc(52% - ${this.data['y预测'] * 55}px)`
    },
    left() {
      return `calc(34% + ${this.data['x预测'] * 73}px)`
    }
  }
}

</script>

<style scoped>
.chart_dot {
  width: 20px;
  height: 20px;
  border-radius: 50%;
  background-color: rgb(30, 0, 255);
  position: absolute;
}
</style>
