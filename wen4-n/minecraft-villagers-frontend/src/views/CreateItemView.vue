<template>
  <div class="page-wrapper">
    <b-card header="Создание нового предмета" class="big-card shadow">
      <item-form
        :initialItem="{ id: 0, name: '', quantity: 1 }"
        :onCancel="onCancel"
        :onSave="onSave"
      />
    </b-card>
  </div>
</template>
<script>
import { createItem } from "../api/items";
import ItemForm from "../components/ItemForm.vue";

export default {
  methods: {
    onCancel() {
      this.$router.push("/items");
    },
    async onSave(item) {
      await createItem(item);
      this.$router.push("/items");
    },
  },
  components: {
    ItemForm,
  },
};
</script>
