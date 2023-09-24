<template>
  <el-popover placement="top-start" width="200" trigger="hover">
    <div>x定位: {{ data['xposition'] }}</div>
    <div>y定位: {{ data['yposition'] }}</div>
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
      return `calc(52% - ${this.data['yposition'] * 55}px)`
    },
    left() {
      return `calc(34% + ${this.data['xposition'] * 73}px)`
    }
  }
}

</script>

<style scoped>
.chart_dot {
  width: 6px;
  height: 6px;
  border-radius: 50%;
  background-color: rgb(251, 255, 0);
  position: absolute;
}
</style>
