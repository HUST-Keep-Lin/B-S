<template>
  <el-popover placement="top-start" width="200" trigger="hover">
    <div>x真实: {{ data['xtruth'] }}</div>
    <div>y真实: {{ data['ytruth'] }}</div>
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
      return `calc(52% - ${this.data['ytruth'] * 55}px)`
    },
    left() {
      return `calc(34% + ${this.data['xtruth'] * 73}px)`
    }
  }
}

</script>

<style>
.chart_dot {
  width: 20px;
  height: 20px;
  border-radius: 50%;
  background-color: crimson;
  position: absolute;
}
</style>
