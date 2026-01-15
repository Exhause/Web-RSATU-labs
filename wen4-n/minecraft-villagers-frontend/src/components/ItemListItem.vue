<template>
  <b-container fluid class="p-0">
    <div>
      Название: <strong>{{ item.name }}</strong>
    </div>
    <div>
      Количество: <strong>{{ item.quantity }}</strong>
    </div>
  </b-container>
</template>

<script>
export default {
  props: {
    item: {
      type: Object,
      required: true,
    },
  },
};
</script>
